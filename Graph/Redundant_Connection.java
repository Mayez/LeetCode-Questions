/*PROBLEM
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.

*/
class Solution {
    public int getParentIndex(int[] arr, int currNode)
    {
        while(arr[currNode] > -1)
        {
            currNode = arr[currNode];
        }
        return currNode;
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        Solution funcs = new Solution();
        int[] arr = new int[edges.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = -1;
        int index = 0;
        for(int j = 0; j < edges.length; j++)
        {
//            System.out.println("J: " + j);
//            System.out.println("CURR INDEX 1: " + (edges[j][0]-1));
            int currNode1 = funcs.getParentIndex(arr,edges[j][0]-1);
//            System.out.println("CURR NODE 1 : " + currNode1);
//            System.out.println("CURR INDEX 2: " + (edges[j][1]-1));
            int currNode2 = funcs.getParentIndex(arr,edges[j][1]-1);
//            System.out.println("CURR NODE 1 : " + currNode2 + "\n");
            if(currNode1 != currNode2)
            {
                if(arr[currNode1] == -1 && arr[currNode2] == -1 || arr[currNode1] != -1 && arr[currNode2] != -1)
                    arr[currNode2] = currNode1;
                
                else if(arr[currNode1] == -1 && arr[currNode2] != -1)
                    arr[currNode1] = currNode2;
                
                else if(arr[currNode1] != -1 && arr[currNode2] == -1)
                    arr[currNode2] = currNode1;
                                               
            }
            else
            {
                index = j;
                break;
            }
        }

//        for(int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + ", ");
        
        return edges[index];
    }
}
