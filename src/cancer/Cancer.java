
package cancer;

import java.io.*;
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

    public static void main(String[] args) throws IOException
    {
        int count = 0;
        int row, col, option;
        String fileName;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Please choose one option:\n1. Import your own file.\n2. Generate random file.");
        option = input.nextInt();
        
        for (int i = 0; i < 17; i++) 
        {
            for (int j = 0; j < 17; j++) 
            {
                grid[i][j] = " ";
            }
        }
        input.close();
        if (option == 1)
        {
            System.out.println("Please enter the file name(Please include .csv)");
            fileName = input.nextLine();

            File in = new File(fileName);

            Scanner read = new Scanner(in);
            read.useDelimiter(",|\r\n");

            for (int i = 1; i <= 15; i++)
            {
                for (int j = 0; j <= 15; j++)
                {
                    grid[i][j] = read.next();
                }
            }
            
        }
        else
        {
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
