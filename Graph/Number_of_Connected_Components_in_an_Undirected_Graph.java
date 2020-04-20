/*PROBLEM
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2

Example 2:
Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
import java.util.LinkedList;
class Solution {
    
    public ArrayList<ArrayList<Integer>> addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
        return adj;
    }
    
    public ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> adj, int numVerts, ArrayList<Integer>elemVisited)
    {
        boolean visited[] = new boolean[numVerts];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        visited[start] = true;
        queue.add(start);
        while(queue.size() != 0)
        {
            start = queue.poll();
            elemVisited.add(start);
//            System.out.println(start);
            Iterator<Integer> it = adj.get(start).listIterator();
            while(it.hasNext())
            {
                int n = it.next();
                if(!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return elemVisited;
    }
    
    public int countComponents(int n, int[][] edges) {
        Solution funcs = new Solution();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int j = 0; j < edges.length; j++)
        {
            adj = funcs.addEdge(adj,edges[j][0],edges[j][1]);
        }
        ArrayList<Integer>visited = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            if(visited.indexOf(i) == -1)
            {
                visited = funcs.bfs(i,adj,n,visited);
//                System.out.println(visited);
                count++;
            }
        }
//        System.out.println("COUNT: " + count);
//        System.out.println(adj);
        return count;
    }
}
