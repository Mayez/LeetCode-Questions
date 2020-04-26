/*
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:
Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:
Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]
 
Note:

1 <= N <= 10000
0 <= paths.size <= 20000
No garden has 4 or more paths coming into or leaving it.
It is guaranteed an answer exists.
*/
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i = 0; i < paths.length; i++)
        {
            adj.get(paths[i][0]-1).add(paths[i][1]);
            adj.get(paths[i][1]-1).add(paths[i][0]);
        }
        

        for(int i = 0; i < adj.size(); i++)
        {
            ArrayList<Integer> options = new ArrayList<Integer>();
            for(int j = 0; j < adj.get(i).size(); j++)
            {
                options.add(arr[adj.get(i).get(j)-1]);
            }
            if(options.indexOf(1) == -1)
                arr[i] = 1;
            else if(options.indexOf(2) == -1)
                arr[i] = 2;
            else if(options.indexOf(3) == -1)
                arr[i] = 3;
            else if(options.indexOf(4) == -1)
                arr[i] = 4;
        }
 //       System.out.println(adj);
        return arr;
    }
}
