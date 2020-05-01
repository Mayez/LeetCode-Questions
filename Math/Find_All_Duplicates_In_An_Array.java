/*PROBLEM
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
import java.util.HashMap;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++)
        {
            if(hmap.containsKey(nums[i]) == false)
                hmap.put(nums[i],1);
            else if(hmap.containsKey(nums[i]))
                list.add(nums[i]);
        }
        return list;
    }
}
