/*PROBLEM
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/

import java.util.HashMap;
import java.util.Collections;
class Solution {
    public int[][] merge(int[][] intervals) {
        HashMap<Integer,Integer> n = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> retIntervals = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < intervals.length; i++)
        {
            if(n.containsKey(intervals[i][0]) == false)
                n.put(intervals[i][0],intervals[i][1]);
            else if(n.containsKey(intervals[i][0]) == true)
            {
                if(n.get(intervals[i][0]) < intervals[i][1])
                    n.put(intervals[i][0],intervals[i][1]);
            }
            
            if(list.indexOf(intervals[i][0]) == -1)
                list.add(intervals[i][0]);
            if(list.indexOf(intervals[i][1]) == -1)
                list.add(intervals[i][1]);
        }
         
        Collections.sort(list);
        
        int start = 0;
        int end = 0;
        for(int j = 0; j < list.size(); j++)
        {            
            if(list.indexOf(n.get(list.get(j))) != -1 && end < list.indexOf(n.get(list.get(j))))
                end = list.indexOf(n.get(list.get(j)));
            
            if(j == end)
            {
//                System.out.println("START: " + list.get(start));
//                System.out.println("END: " + list.get(end));
                retIntervals.add(new ArrayList<Integer>());
                retIntervals.get(retIntervals.size()-1).add(list.get(start));
                retIntervals.get(retIntervals.size()-1).add(list.get(end));
                if(j+1 < list.size())
                {
                    start = j+1;
                    end = j+1;
                }
            }
            
        }
        
        int[][] merging = new int[retIntervals.size()][2];
        for(int k = 0; k < retIntervals.size(); k++)
        {
            merging[k][0] = retIntervals.get(k).get(0);
            merging[k][1] = retIntervals.get(k).get(1);
        }
        
//        System.out.println(n);
//        System.out.println(list);
        return merging;    
    }
}
