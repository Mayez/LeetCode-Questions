/*PROBLEM
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
*/
import java.lang.Math;
class Solution {
    public double originDist(int x, int y)
    {
        return Math.pow(Math.pow(x,2)+Math.pow(y,2),.5);
    }
    
    public int[][] sort(int arr[][])
    {
        int n = arr.length; 
        
        //build heap
        for(int i = n/2 - 1; i >= 0; i--)
            heapify(arr,n,i);
        
        //delete heap
        for(int i = n-1; i > 0; i--)
        {
            int temp = arr[0][0];
            arr[0][0] = arr[i][0];
            arr[i][0] = temp;

            temp = arr[0][1];
            arr[0][1] = arr[i][1];
            arr[i][1] = temp;
            
            heapify(arr,i,0);
        }
        return arr;
    }
    
    public void heapify(int[][] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        
        if(l < n && originDist(arr[l][0],arr[l][1]) > originDist(arr[largest][0],arr[largest][1]))
            largest = l;
        
        if(r < n && originDist(arr[r][0],arr[r][1]) > originDist(arr[largest][0],arr[largest][1]))
            largest = r;
        
        if(largest != i)
        {
            int swap1 = arr[i][0];
            arr[i][0] = arr[largest][0];
            arr[largest][0] = swap1;

            swap1 = arr[i][1];
            arr[i][1] = arr[largest][1];
            arr[largest][1] = swap1;

            
            heapify(arr,n,largest);
        }
     }
    
    public int[][] kClosest(int[][] points, int K) {
        Solution funcs = new Solution();
        points = funcs.sort(points);
        
        int[][] arr = new int[K][2];
        
        for(int i = 0; i < K; i++)
        {
            arr[i][0] = points[i][0];    
            arr[i][1] = points[i][1];    
        }
        
        return arr;
    }
}
