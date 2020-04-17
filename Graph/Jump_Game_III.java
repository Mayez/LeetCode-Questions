/*PROBLEM
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

Example 1:
Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 

Example 2:
Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3

Example 3:
Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 
Constraints:

1 <= arr.length <= 5 * 10^4
0 <= arr[i] < arr.length
0 <= start < arr.length
*/
import java.util.LinkedList;

class Solution {
    public ArrayList<ArrayList<Integer>> addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        return adj;
    }
   
    // prints BFS traversal from a given source s 
    public boolean BFS(int s, ArrayList<ArrayList<Integer>> adj, int numVerts, int[] arr) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[numVerts]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            if(arr[s] == 0)
                return true;
    //        System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj.get(s).listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
        return false;
    } 
        
    public boolean canReach(int[] arr, int start) {
        Solution funcs = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(arr.length);
        
        for(int i = 0; i < arr.length; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i = 0; i < arr.length; i++)
        {
            if(i+arr[i] < arr.length)
                adj = funcs.addEdge(adj,i,(i+arr[i]));   
            if(i-arr[i] >= 0)
                adj = funcs.addEdge(adj,i,(i-arr[i]));
        }
        
//        System.out.println(adj);
        boolean state = false;
        state = funcs.BFS(start,adj,arr.length,arr);
        return state;
    }
}
