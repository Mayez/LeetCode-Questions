/*PROBLEM
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
*/

class Solution {
    int BinItr(int arr[], int left, int right, int x)
    {
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] < x && arr[left] <= x && arr[mid] < arr[left])
                right = mid - 1;
            else if(arr[mid] > x && arr[right] >= x && arr[mid] > arr[right])
                left = mid + 1;
            else if(arr[mid] < x)
                left = mid + 1;
            else if(arr[mid] > x)
                right = mid - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        Solution t = new Solution();
        int val = t.BinItr(nums,0,nums.length-1,target);
        return val;
    }
}
