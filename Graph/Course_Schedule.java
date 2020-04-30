/*PROBLEM
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 
Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5

To solve I used a combination of topological sort and cycle detection for dfs in a directed graph
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
    
    public boolean topologicalSort(ArrayList<ArrayList<Integer>> graph, int numVerts)
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
        
        if(stack.size() == numVerts)
            return true;
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Solution funcs = new Solution();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        
        for(int i = 0; i < prerequisites.length; i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        
        boolean state = false;
        
        state = funcs.isCyclic(graph,numCourses);
        
        if (state == true)
        {
//            System.out.println("CYCLE DETECTED");
            return false;
        }
        
        boolean state1 = false;
        state = funcs.topologicalSort(graph,numCourses);
        
        return state;
    }
}
