/*PROBLEM
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
*/
import java.util.*;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> n = new HashMap<>();
        List<Integer> test = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            index = nums[i];
            if(n.containsKey(index) == false)
                n.put(index,1);
            else if(n.containsKey(index) != false)
                n.put(index,n.get(index)+1);
        }
        System.out.println(n);
        int count0 = n.size();
        for(int j = 0; j < count0-k; j++)
        {
            int min = Collections.min(n.values());
            System.out.println(min);
            int count = n.size();
            n.entrySet().removeIf(entry -> (min == entry.getValue()));
            int count1 = n.size();
            if(count - count1 > 1)
                j += (count - count1) - 1;
            System.out.println(n);
        }
        
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            test.add((int)mentry.getKey());
        }
        return test;
    }
}
