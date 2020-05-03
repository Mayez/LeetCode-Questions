/*PROBLEM
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.

***Very similar to the kth largest element but this time we are working with a 2d array (matrix).
Could probably be improved using a min heap instead of a max heap and stopping at the kth smallest element
as opposed to sorting the whole thing
*/
class Solution {
    public void heapSort(int[][] arr)
    {
        int n = arr.length*arr.length;
        for(int i = n/2-1; i >= 0; i--)
            heapify(arr,n,i);
        
        for(int i = n-1; i >= 0; i--)
        {
            int temp = arr[0][0];
            arr[0][0] = arr[i/arr[0].length][i%arr[0].length];
            arr[i/arr[0].length][i%arr[0].length] = temp;
            heapify(arr,i,0);
        }
    }
    
    public void heapify(int[][] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;
        
        if(l < n && arr[largest/arr[0].length][largest%arr[0].length] < arr[l/arr[0].length][l%arr[0].length])
            largest = l;
        
        if(r < n && arr[largest/arr[0].length][largest%arr[0].length] < arr[r/arr[0].length][r%arr[0].length])
            largest = r;
        
        if(largest != i)
        {
            int swap = arr[i/arr[0].length][i%arr[0].length];
            arr[i/arr[0].length][i%arr[0].length] = arr[largest/arr[0].length][largest%arr[0].length];
            arr[largest/arr[0].length][largest%arr[0].length] = swap;
            heapify(arr,n,largest);
        }

    }
    
    public int kthSmallest(int[][] matrix, int k) {
        Solution funcs = new Solution();
        funcs.heapSort(matrix);
/*        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        
        
        System.out.println("ROW: " + k/matrix[0].length);
        System.out.println("COL: " + k%matrix[0].length);*/
        return matrix[(k-1)/matrix[0].length][(k-1)%matrix[0].length];
    }
}
