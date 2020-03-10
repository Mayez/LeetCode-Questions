/*
PROBLEM:
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] spiral = new int[n][n];
        int count = 0;
        int margins = 0;
        while(count < n*n)
        {
            int j = margins;
            int i = margins;
            for(j = margins; j < (n-margins); j++)
            {
                count++;
                spiral[i][j] = count;
            }
            j--;
            for(i = margins+1; i < (n-margins); i++)
            {
                count++;
                spiral[i][j] = count;
            }
            i--;
            for(j = n-margins-2; j >= margins; j--)
            {
                count++;
                spiral[i][j] = count;            
            }
            j++;
            for(i = n-margins-2; i >= margins+1; i--)
            {
                count++;
                spiral[i][j] = count;
            }
            margins++;
        }        
        return spiral;
    }
}
