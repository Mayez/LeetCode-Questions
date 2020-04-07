/*PROBLEM
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3

Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
*/
class Solution {
    public int majorityElement(int[] nums) {
        int[] bits = new int[32]; 
        int result = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int number = nums[i];
            int pos = 0;
            while(number != 0 && pos < 32)
            {
                if((number & 1) == 1)
                {
                    bits[pos]++;
                    if(bits[pos] > (nums.length/2))
                    {
                        result = result | (1 << pos);
                    }
                }
                number = number >> 1;
                pos++;
            }
        }
//        System.out.println("RES: " + result);
        return result;
    }
}
