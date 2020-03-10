/*
PROBLEM:
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(i-1 >= 0)
            {
                product *= nums[i-1];
                output[i] = product;
            }
            else 
                output[i] = 1;
        }
        product = 1;
        for(int j = nums.length-1; j >= 0; j--)
        {
            if(j+1 <= nums.length-1)
            {
                product *= nums[j+1];
                output[j] *= product;
            }
        }
        return output;
    }
}
