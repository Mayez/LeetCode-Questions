/*PROBLEM
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .

Example 2:
Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

*********This is almost the same as Course Schedule but the only difference is that the actual list is returned this time instead of 
a corresponding boolean state. The logic is still the same though.
*/
import java.util.List;
class Solution {
    public boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> graph)
    {
        if(recStack[i])
            return true;
        if(visited[i])
            return false;
        
        visited[i] = true;
        
        recStack[i] = true;
        List<Integer> children = graph.get(i);
                
        for(Integer j : children)
        {
            if(isCyclicUtil(j,visited,recStack,graph))
                return true;
        }
        recStack[i] = false;
        return false;
    }
    
    public boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int numVerts)
    {
        boolean[] visited = new boolean[numVerts];
        boolean[] recStack = new boolean[numVerts];
        
        for(int i = 0; i < numVerts; i++)
        {
            if(isCyclicUtil(i,visited,recStack,graph))
                return true;
        }
        return false;
    }
    
    public void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack, ArrayList<ArrayList<Integer>> graph)
    {
        visited[i] = true;
        Integer k;
        
        Iterator<Integer> it = graph.get(i).iterator();
        while(it.hasNext())
        {
            k = it.next();
            if(!visited[k])
                topologicalSortUtil(k,visited,stack,graph);
        }
        
        stack.push(new Integer(i));
    }
    
    public int[] topologicalSort(ArrayList<ArrayList<Integer>> graph, int numVerts)
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] visited = new boolean[numVerts];
        
        for(int i = 0; i < numVerts; i++)
            visited[i] = false;
        
        for(int i = 0; i < numVerts; i++)
        {
            if(visited[i] == false)
                topologicalSortUtil(i,visited,stack,graph);
        }
        
        int[] arr = new int[numVerts];
        int count = 0;
        while(stack.empty() == false)
        {
            arr[count] = stack.pop();
            count++;
        }
        return arr;
    }
    
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Solution funcs = new Solution();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        
        for(int i = 0; i < prerequisites.length; i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        boolean state = false;
        
        state = funcs.isCyclic(graph,numCourses);
        
        int arr[] = new int[0];
        if (state == true)
        {
//            System.out.println("CYCLE DETECTED");
            return arr;
        }
        arr = new int[numCourses];
        arr = funcs.topologicalSort(graph,numCourses);
        return arr;
    }
}
