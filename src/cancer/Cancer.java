
package cancer;

import java.util.Scanner;

public class Cancer 
{

    static String[][] grid = new String[17][17];

    public static void cancer(int row, int col)
    {
        if (grid[row][col].equals("-")) 
        {
            grid[row][col] = " ";
            cancer(row - 1, col - 1);
            cancer(row - 1, col);
            cancer(row - 1, col + 1);
            cancer(row, col - 1);
            cancer(row, col + 1);
            cancer(row + 1, col - 1);
            cancer(row + 1, col);
            cancer(row + 1, col + 1);
        }
    }

    public static void printGrid()
    {
        for (int i = 1; i <= 15; i++)
        {
            for (int j = 1; j <= 15; j++)
            {
                System.out.print(grid[i][j]);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        int count = 0;
        int row, col;
        
        for (int i = 0; i < 17; i++) 
        {
            for (int j = 0; j < 17; j++) 
            {
                grid[i][j] = " ";
            }
        }

        for (int i = 1; i <= 15; i++)
        {
            for (int j = 1; j <= 15; j++)
            {
                grid[i][j] = "+";
            }
        }

        for (int i = 0; i < 30; i++) 
        {
            row = (int)(Math.random() * 15 + 1);
            col = (int)(Math.random() * 15 + 1);
            grid[row][col] = "-";
        }
        
        printGrid();

        for (int i = 1; i <= 15; i++)
        {
            for (int j = 1; j <= 15; j++)
            {
                if (grid[i][j].equals("-"))
                {
                    cancer(i, j);
                    count++;
                }
            }
        }

        System.out.println("\n\nThe file has " + count + " cancers in it");
        System.out.println("The new grid is:\n");

        printGrid();
    }
    
}
