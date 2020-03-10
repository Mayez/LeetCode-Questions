/*
PROBLEM:
Given an array of integers, print histogram of array values.

Examples:

Input : 0 11 2 13 5 12 8 11 12 9
Output :                  
13 |           x                   
12 |           x     x        x    
11 |     x     x     x     x  x    
10 |     x     x     x     x  x    
 9 |     x     x     x     x  x  x 
 8 |     x     x     x  x  x  x  x 
 7 |     x     x     x  x  x  x  x 
 6 |     x     x     x  x  x  x  x 
 5 |     x     x  x  x  x  x  x  x 
 4 |     x     x  x  x  x  x  x  x 
 3 |     x     x  x  x  x  x  x  x 
 2 |     x  x  x  x  x  x  x  x  x 
 1 |     x  x  x  x  x  x  x  x  x 
 0 |  x  x  x  x  x  x  x  x  x  x 
---------------------------------------
      0 11  2 13  5 12  8 11 12  9 


Input : 10 9 12 4 5 2 8 5 3 1
Output :                 
12 |        x                      
11 |        x                      
10 |  x     x                      
 9 |  x  x  x                      
 8 |  x  x  x           x          
 7 |  x  x  x           x          
 6 |  x  x  x           x          
 5 |  x  x  x     x     x  x       
 4 |  x  x  x  x  x     x  x       
 3 |  x  x  x  x  x     x  x  x    
 2 |  x  x  x  x  x  x  x  x  x    
 1 |  x  x  x  x  x  x  x  x  x  x 
 0 |  x  x  x  x  x  x  x  x  x  x 
---------------------------------------
     10  9 12  4  5  2  8  5  3  1*/
     
public class Histogram{
	public static void main(String[] args)
	{
		int arr[] = {0,11,2,13,5,12,8,11,12,9};
		int maxVal = 0;
		int j = 0;
		for(int i = 0; i < arr.length-1;i++)
		{
			if(arr[i] >= maxVal)
				maxVal = arr[i];
		}
		System.out.println("Max Val: " + maxVal);
		for(j = maxVal; j >= 0; j--)
		{
			if(j >= 10)
				System.out.print(j + "|");
			else
				System.out.print(j + " |");
			for(int k = 0; k < arr.length; k++)
			{
				if(arr[k] >= j)
					System.out.print("x ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
