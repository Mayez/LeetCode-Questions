/*PROBLEM
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.

Example 1:
Input: grid = [[1,0],[0,1]]
Output: 0
Explanation: No servers can communicate with others.

Example 2:
Input: grid = [[1,0],[1,1]]
Output: 3
Explanation: All three servers can communicate with at least one other server.

Example 3:
Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
Output: 4
Explanation: The two servers in the first row can communicate with each other. The two servers in the third column can communicate with each other. The server at right bottom corner can't communicate with any other server.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 250
1 <= n <= 250
grid[i][j] == 0 or 1
*/
class Solution {    
    public ArrayList<ArrayList<Integer>> addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        return adj;
    }
    
    public int countServers(int[][] grid) {
        Solution funcs = new Solution();
        int count = 0;
        ArrayList<Integer> serverCount = new ArrayList<Integer>();
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[i].length; j++)
            {
//                System.out.print(grid[i][j]);
                if(grid[i][j] == 1)
                    serverCount.add(count);
  //              System.out.print(count);
                count++;
            }
 //           System.out.println();
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(serverCount.size());
        for(int i = 0; i < serverCount.size(); i++)
            adj.add(new ArrayList<Integer>());

        int row1 = 0;
        int col1 = 0;
        int left1 = 0;
        int right1 = 0;
        int top1 = 0;
        int bottom1 = 0;
        for(int k = 0; k < serverCount.size(); k++)
        {            
//            System.out.print(serverCount.get(k));
            row1 = serverCount.get(k)/grid[0].length;
            col1 = serverCount.get(k)%grid[0].length;
            left1 = (row1*grid[0].length);
            right1 = ((row1+1)*grid[0].length-1);
            top1 = col1;
            bottom1 = ((grid[0].length)*(grid.length-1)+col1);
 //           System.out.println(" ROW: " + row1 + ", COL: " + col1);
//            System.out.println(", LEFT: " + (row1*grid[0].length) + ", RIGHT: " + ((row1+1)*grid[0].length-1) + ", TOP: " + col1 + ", BOTTOM: " + ((grid[0].length)*(grid.length-1)+col1));
            for(int m = k+1; m < serverCount.size(); m++)
            {
                int row2 = serverCount.get(m)/grid[0].length;
                int col2 = serverCount.get(m)%grid[0].length;
                int left2 = (row2*grid[0].length);
                int right2 = ((row2+1)*grid[0].length-1);
                int top2 = col2;
                int bottom2 = ((grid[0].length)*(grid.length-1)+col2);
                if(top1 == top2 && bottom1 == bottom2 || left1 == left2 && right1 == right2)
                {
                    adj = funcs.addEdge(adj,k,serverCount.get(m));
                    adj = funcs.addEdge(adj,m,serverCount.get(k));
                }
            }

        }
        int finalCount = 0;
        for(int o = 0; o < adj.size(); o++)
        {
            if(adj.get(o).size() > 0)
                finalCount++;
        }
//        System.out.println(adj);
//        System.out.println(finalCount);
        return finalCount;
    }
}
