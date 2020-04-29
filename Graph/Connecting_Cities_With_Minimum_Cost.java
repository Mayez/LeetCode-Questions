/*PROBLEM
There are N cities numbered from 1 to N.

You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.

Example 1:
Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
Output: 6
Explanation: 
Choosing any 2 edges will connect all cities so we choose the minimum 2.

Example 2:
Input: N = 4, connections = [[1,2,3],[3,4,4]]
Output: -1
Explanation: 
There is no way to connect all cities even if all edges are used.

Note:

1 <= N <= 10000
1 <= connections.length <= 10000
1 <= connections[i][0], connections[i][1] <= N
0 <= connections[i][2] <= 10^5
connections[i][0] != connections[i][1]

This solutions implements a greedy algorithm known as Prims Algorithm. There is an alternative which is Kruskal's Algorithm but,
I stuck with Prims as that one requires more cycle detection
*/
public class Node{
    int edgeVal;
    int cityTo; 
}

class Solution {     
    public int primsAlgo(ArrayList<ArrayList<Node>> graph, int numVerts)
    {
        int cost = 0;
        //to indicate which vertexs you have already visited
        boolean[] visited = new boolean[numVerts];
        //Using a priority queue 
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        
        //setting vertex 1 to visited as this algorithm will always start off at node 1
        visited[0] = true;
        
        //adds every adjacent vertex and edge to the queue
        for(int i = 0; i < graph.get(0).size(); i++)
            priorityQueue.add(graph.get(0).get(i));
        
        //this while loop will continue until there are no more entries left in the priority queue
        while(!priorityQueue.isEmpty())
        {
            //remove the first entry of the queue
            Node node = priorityQueue.remove();
//            System.out.println("NODE: " + node.cityAt + ", OTHER: " + node.cityTo);
            
            //if the vertex is already visited skip to next entry in priority queue
            if(visited[node.cityTo-1] == true)
                continue;
            
            //otherwise mark this vertex to be true
            visited[node.cityTo-1] = true;
            
            //add cost of edge to totalcost
            cost+= node.edgeVal;
            
            // for every edge connected to the opposite vertex, add it to the PriorityQueue
            for(int i = 0; i < graph.get(node.cityTo-1).size(); i++)
                priorityQueue.add(graph.get(node.cityTo-1).get(i));
            
        }
        
        // if we haven't visited all of the vertices, return -1
        for(int i = 0; i < visited.length; i++)
        {
            if(visited[i] == false)
                return -1;
        }
        
  //      System.out.println("COST: " + cost);
        return cost;
    }
    
    
    public int minimumCost(int N, int[][] connections) {
        Solution funcs = new Solution();
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < N; i++)
            graph.add(new ArrayList<Node>());
        
        for(int i = 0; i < connections.length; i++)
        {
            /*this is meant to add to the graph and sort it by the edgeval at the same time to where the 
            min edgeval is first in arraylist*/
            graph.get(connections[i][0]-1).add(new Node(connections[i][1],connections[i][2]));
            graph.get(connections[i][1]-1).add(new Node(connections[i][0],connections[i][2]));
        }
        
/*        for(int i = 0; i < graph.size(); i++)
        {
            for(int j = 0; j < graph.get(i).size(); j++)
            {
                System.out.println("I: " + (i+1) + ", POINTS TO: " + graph.get(i).get(j).cityTo + ", EDGE VAL: " + graph.get(i).get(j).edgeVal);
            }
        }*/

        int cost = funcs.primsAlgo(graph, N);        

        return cost;
    }
    
    //meant for any new nodes created
    static class Node implements Comparable<Node> {
		int cityTo, edgeVal;
    //constructor
		public Node(int cityTo, int edgeVal) {
			this.cityTo = cityTo;
			this.edgeVal = edgeVal;
		}
    //this is where the sorting portion of the arraylist which is meant to sort by smallest edgeval first is done
		public int compareTo(Node node) {
			return this.edgeVal - node.edgeVal;
		}
	}
    
}
