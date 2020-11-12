//*******************************************************
// Author: Jhanvi Shah 818152
//
// Assignment: J8C2 Foxen Treasure
//
/* Description: This program dipicts the following senerio.
    There are foxes guarding some food
    The first input is for how many senerios there are. 

    Input
    Line 1: 1 integer, T
    For each scenario: 
    Line 1: 1 integer, N
    Next N lines: 3 integers, Ai, Si, and Oi, for i = 1..N
    
    Output
    For each scenario:
    Line 1: 1 integer, the minimum number of hours after the start
    to wait until all of the Foxen are asleep during the same hour. 
    If this will never happen, output the string "Foxen are too powerful"
    (without quotes) instead.
*/
// Date Start: Sept 20, 2019
// Date Completed: October 1, 2019
//
// Completion time: 5 hours
//
// Honor Code: I pledge that this program represents my own
//   program code. I received help from no one in designing
//   and debugging my program.
//*********************************************************
import java.util.*;
public class FoxenTresure
{
   public static int [] hours1 = new int [23];
   public static int [] hours2 = new int [23];
   public static void main (String[] args)
   {
      Scanner input = new Scanner (System.in);
      int T, N;
      int Ai = 0;
      int Si = 0;
      int Oi = 0;
      int hours2High = 1;
   
      //System.out.println ("Enter T Value: ");
      T = input.nextInt ();
      
      for (int i = 1; i <= T; i++)
      {
         for (int x = 0; x < hours2.length; x++)
         {  
            hours2 [x] = hours2High;
         } 
         
         //System.out.println ("Enter N Value: ");
         N = input.nextInt ();
      
         for (int j = 1; j <= N; j++)
         {
                
            //System.out.println ("Fox " + j + ":");
            //System.out.println ("Enter Ai Value: ");
            Ai = input.nextInt ();
            //System.out.println ("Enter Si Value: ");
            Si = input.nextInt ();
            //System.out.println ("Enter Oi Value: ");
            Oi = input.nextInt ();
            
            fox1 (Ai, Si, Oi);
            
            //***************************************************
            /*System.out.println ("Hours 1");
            for (int x = 0; x < hours1.length; x++)
            {
               System.out.print (hours1[x] + " ");
            }
            System.out.println ();
            System.out.println ("Hours 2");
            for (int x = 0; x < hours2.length; x++)
            {  
               System.out.print (hours2 [x] + " ");
            }*/
            //***************************************************
            for (int l = 0; l < hours1.length; l++)
            {
               if ((hours1 [l] == 0) && (hours2 [l] == hours2High))
               {
                  hours2 [l] = (hours2High+1);
               }
            }// end for
            hours2High = hours2High + 1;
            
            //***************************************************
            /*for (int x = 0; x < hours2.length; x++)
            {
               System.out.print (hours2[x] + " ");
            }*/
            //***************************************************
         }// end j loop
         
         int b = 0;
         do
         {
            if (hours2[b] == hours2High)
            {
               System.out.println (b);
               b = b + 1;
            }
            else
            {
               b = b + 1;
            }
         }
         while ((hours2 [b-1] != hours2High) && (b < 23));
         
         if (b == 23)
         {
            System.out.println ("Foxen are too powerful!");
         }      
      
      }// end of T loop
   } // end main method
         
   public static int[] fox1 (int Ai, int Si, int Oi)
   {        
      int k = 0;
      Oi = Oi + 1;
      while (k < 23) 
      {
         if (Oi <= Ai)
         {
           // System.out.println (hours1 [k] = 1);
            hours1 [k] = 1;
            Oi = Oi + 1;
         }
         else
         {
           // System.out.println (hours1 [k] = 2);
            hours1 [k] = 0;
            Oi = Oi + 1;
         }
              
         if (Oi > (Si + Ai))
         {
            Oi = 1;
         }
              
         k = k + 1;
      }
      return hours1;
   }    

} // end class
//*********************************************************
/* OUTPUT
    Enter T Value: 
    2
    Enter N Value: 
    2
    Fox 1:
    Enter Ai Value: 
    2
    Enter Si Value: 
    1
    Enter Oi Value: 
    2
    
    Fox 2:
    Enter Ai Value: 
    2
    Enter Si Value: 
    2
    Enter Oi Value: 
    1
 
    6
    Enter N Value: 
    3
    Fox 1:
    Enter Ai Value: 
    1
    Enter Si Value: 
    1
    Enter Oi Value: 
    0
    
    Fox 2:
    Enter Ai Value: 
    1
    Enter Si Value: 
    1
    Enter Oi Value: 
    0
 
    Fox 3:
    Enter Ai Value: 
    1
    Enter Si Value: 
    1
    Enter Oi Value: 
    1
    
    Foxen are too powerful!
*/
//*********************************************************
 /*
 2
 2
 2
 1
 2
 2
 2
 1
 6
 3
 1
 1
 0
 1
 1
 0
 1
 1
 1
 Foxen are too powerful!
 */