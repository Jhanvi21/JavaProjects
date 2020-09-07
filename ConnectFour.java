//**********************************************************
// Author: Jhanvi Shah 818152
//
// Assignment: J10C2 Connect Four
//
// Description: Checks if a game of connect four resulted in
//   a win or not. Used a file to show success of program.
//   Text file and results showed at the end.
//
// Date Start: Nov 18, 2019
// Date Completed: Nov 20, 2019
//
// Completion time: 3 hours
//
// Honor Code: I pledge that this program represents my own
//   program code. I received help from Mr.Bozz in designing
//   and debugging my program.
//*********************************************************
import java.io.*;
import java.util.*;
public class ConnectFour
{
   public static void main (String[] args) throws FileNotFoundException
   {
      char game [][] = new char [4][4];
      int t;
      boolean win;
      Scanner file = new Scanner(new File("C2.txt"));
      
      //Number of games being played (5)
      t = file.nextInt ();
      
      for (int i = 1; i <= t; i++)
      {
         //Method to read the file
         game = read(game, file);
         //System.out.println (Arrays.deepToString (game));
         
         if ((canWin(game)) == true)
         {
            System.out.println ("yes");
         }
         else 
         {
            System.out.println ("no");
         }
      }
   }// end main method
   
   public static char [][] read(char grid [][], Scanner file) throws FileNotFoundException
   {
      String x;
      x = file.nextLine ();
            
      for (int r = 0; r < grid.length; r++)
      {
         x = file.nextLine();
         for (int c = 0; c < grid[r].length; c++)
         {
            grid[r][c] = x.charAt(c);
         }
      }
      return grid;
   }// end method
   
   public static boolean canWin (char grid [][])
   {
      boolean test = true;
      char reference;
   
   //checking horizontal win
      for (int r = 0; r < grid.length; r++)
      {
         reference = grid [r][0];
         test = true;
         
         for (int c = 0; c < grid[r].length-1; c++)
         {
            if ((grid [r][c+1] == reference)&& (test == true))
            {
               test = true;
               reference = grid [r][c+1];
            }
            else 
            {
               test = false;
            }
         }//end of nested for
         
         if (test == true)
         {
            return test;
         }//end of return if
            
      }//end of for
   
   //checking vertical win
      if (test == false)
      {
         test = true;
         for (int c = 0; c < grid.length; c++)
         {
            reference = grid [0][c];
            for (int r = 0; r < grid[r].length-1; r++)
            {
               if ((grid [r+1][c] == reference)&& (test == true))
               {
                  test = true;
                  reference = grid [r+1][c];
               }
               else 
               {
                  test = false;
               }
            }//end of nested for
            
            if (test == true)
            {
               return test;
            }//end of return if
            
         }//end of for
      }//end of if statement
   
   //checking diagonal, right - left
      if (test == false)
      {
         test = true;
         int c;
      
         for (int r = 0; r < grid.length-1; r++)
         {
            c = r;
            reference = grid [r][c];
            
            if ((grid [r+1][c+1] == reference)&& (test == true))
            {
               test = true;
               reference = grid [r+1][c+1];
            }
            else 
            {
               test = false;
            }
         }// end of for
      }// end of if statement
      
   //checking diagonal, left - right
      if (test == false)
      {
         test = true;
         int c = 3;
         for (int r = 0; r < grid.length-1; r++)
         {
            reference = grid [r][c];
            if ((grid [r+1][c-1] == reference)&& (test == true))
            {
               test = true;
               c = c-1;
            }
            else 
            {
               test = false;
            }
         }// end of for
      }// end of if statement
      return test;
   }// end method
   
} // end class

//*********************************************************
/*  TEXT FILE:

5
XOXX
XOXO
OXOX
XOOO

XOXO
XXOX
XOXO
XOXO 

XOOO
OXXO
OOXX
XOOX

XOOX
OXXO
XXXX
OOXO

XOXO 
OXXX
OXXX
OXOO
//*********************************************************
    OUTPUT:
yes
yes
yes
yes
no

*/
//*********************************************************