/*PROBLEM
Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false
Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        //first is num, second is occurences
        HashMap<Integer,Integer> n = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(n.containsKey(nums[i]) == false)
                n.put(nums[i],1);
            else if(n.containsKey(nums[i]) != false)
                n.put(nums[i],n.get(nums[i])+1);
        }
        
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if((int)mentry.getValue() >= 2)
                return true;
        }
        return false;
    }
}
