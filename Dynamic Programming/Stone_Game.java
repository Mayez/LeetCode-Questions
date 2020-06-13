/*PROBLEM
Alex and Lee play a game with piles of stones.  There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones.  The total number of stones is odd, so there are no ties.

Alex and Lee take turns, with Alex starting first.  Each turn, a player takes the entire pile of stones from either the beginning or the end of the row.  This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alex and Lee play optimally, return True if and only if Alex wins the game.

Example 1:
Input: [5,3,4,5]
Output: true
Explanation: 
Alex starts first, and can only take the first 5 or the last 5.
Say he takes the first 5, so that the row becomes [3, 4, 5].
If Lee takes 3, then the board is [4, 5], and Alex takes 5 to win with 10 points.
If Lee takes the last 5, then the board is [3, 4], and Alex takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alex, so we return true.
 
Note:
2 <= piles.length <= 500
piles.length is even.
1 <= piles[i] <= 500
sum(piles) is odd.
*/

class Solution {
    
    static boolean status = false;
    
    public ArrayList<Integer> gameOptions(int[] piles, int left, int right, int count,ArrayList<Integer> list, int alexTotal, int leeTotal)
    {        
        if(count == piles.length)
        {
//            System.out.println();
            return list;
        }
        if(status == false)
        {
    //        if(count+1 == piles.length-1)
    //            System.out.println(list);
            list.add(left);
            if(count % 2 == 0)
                alexTotal += piles[left];
            else
                leeTotal += piles[left];
            if(count+1 == piles.length)
            {
//                System.out.println("TEST1: " + list);
//                System.out.println("A TOTAL: " + alexTotal);
//                System.out.println("L TOTAL: " + leeTotal);
                if(alexTotal > leeTotal)
                {
                    status = true;
                }

            }
    //        System.out.println("TEST1: " + list);
    //        System.out.print(left);
            gameOptions(piles,left+1,right,count+1,new ArrayList(list),alexTotal,leeTotal);
            if(count % 2 == 0)
                alexTotal -= piles[list.get(list.size()-1)];
            else
                leeTotal -= piles[list.get(list.size()-1)];
            list.remove(list.size()-1);
            list.add(right);
            if(count % 2 == 0)
                alexTotal += piles[right];
            else
                leeTotal += piles[right];
    //        if(list.size() == piles.length)
    //        {
    //            System.out.println("TEST2: " + list);
    //            System.out.println("A TOTAL: " + alexTotal);
    //            System.out.println("L TOTAL: " + leeTotal);
     //       }
    //        System.out.print(right);
            gameOptions(piles,left,right-1,count+1,new ArrayList(list),alexTotal,leeTotal); 
    //        System.out.println(list);
        }
        return list;
    }
    
    public boolean stoneGame(int[] piles) {
        Solution funcs = new Solution();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = funcs.gameOptions(piles, 0, piles.length-1, 0,list,0,0);
        return status;
    }
}
