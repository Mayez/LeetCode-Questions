/*PROBLEM
We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.

Example 1:
Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
*/
class Solution {
    public int matrixScore(int[][] A) {
        
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int[] arr = new int[A[0].length];
        
        for(int i = 0; i < A.length; i++)
        {
            int val = 0;
            int flag = 0;
            if(A[i][0] == 0)
                flag = 1;
            
            for(int j = 0; j < A[i].length; j++)
            {
                if(flag == 1 && A[i][j] == 0)
                    A[i][j] = 1;
                else if(flag == 1 && A[i][j] == 1)
                    A[i][j] = 0;
                if(A[i][j] == 1)
                    arr[j]++;
                
                val = val | A[i][j];
                if(j < A[i].length-1)
                    val = val << 1;
            }
            nums.add(val);
        }
//        System.out.println(nums);
        int total = 0;
        for(int k = 1; k < A[0].length; k++)
        {
            if(arr[k] <= (A.length/2))
            {
                for(int m = 0; m < nums.size(); m++)
                {
                    int val2 = 1 << (A[0].length-k-1);
                    nums.set(m,nums.get(m)^val2);
                }
            }
        }
        
        for(int p = 0; p < nums.size(); p++)
            total += nums.get(p);
        
//        System.out.println(total);
        return total;
    }
}
