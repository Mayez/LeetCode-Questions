/*
PROBLEM
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input: 
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output: 
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]
*/
class Solution {
    public void gameOfLife(int[][] board) {
        int n = board[0].length;
        int m = board.length;
        int [][] newBoard = new int[m][n];
        int counter = 0;
        if(m > 1 && n > 1)
        {
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    counter = 0;
                    if(i+1 >= m)
                    {
                        if(j-1 < 0)
                        {
                            counter = board[i][j+1]+ board[i-1][j] + board[i-1][j+1]; 
                        }

                        else if(j+1 >= n)
                        {
                            counter = board[i-1][j-1] + board[i-1][j] + board[i][j-1];
                        }

                        else
                        {
                            counter = board[i][j+1] + board[i-1][j+1] + board[i-1][j] + board[i-1][j-1] + board[i][j-1];
                        }
                    }

                    else if(i-1 < 0)
                    {
                        if(j-1 < 0)
                        {
                            counter = board[i][j+1] + board[i+1][j+1] + board[i+1][j];
                        }

                        else if(j+1 >= n)
                        {
                            counter = board[i][j-1] + board[i+1][j] + board[i+1][j-1];
                        }

                        else
                        {
                            counter = board[i+1][j+1] + board[i][j+1] + board[i+1][j] + board[i+1][j-1] + board[i][j-1];
                        }
                    }

                    else if(j+1 >= n && i-1 >= 0 && i+1 < m)
                    {
                        counter = board[i-1][j] + board[i-1][j-1] + board[i][j-1] + board[i+1][j-1] + board[i+1][j];
                    }

                    else if(j-1 < 0 && i-1 >= 0 && i+1 < m)
                    {
                       counter = board[i-1][j] + board[i-1][j+1] + board[i][j+1] + board[i+1][j+1] + board[i+1][j]; 
                    }

                    else
                    {
                        counter = board[i+1][j+1] + board[i][j+1] + board[i-1][j+1] + board[i-1][j] + board[i+1][j] + board[i+1][j-1] + board[i][j-1] + board[i-1][j-1];
                    }

                    if((counter < 2 || counter > 3) && board[i][j] == 1)
                        newBoard[i][j] = 0;
                    else if(board[i][j] == 1 && (counter == 2 || counter == 3))
                        newBoard[i][j] = 1;
                    else if(board[i][j] == 0 && counter == 3)
                        newBoard[i][j] = 1;
                }
            }
        }
        else if( m == 1 && n == 1)
        {
            if(board[0][0] == 0 || board[0][0] == 1)
                newBoard[0][0] = 0;
        }
        for(int k = 0; k < m; k++)
        {

            for(int p = 0; p < n; p++)
            {
                board[k][p] = newBoard[k][p];
                System.out.print(newBoard[k][p] + " ");
            }
            System.out.println();
        }
    }
}
