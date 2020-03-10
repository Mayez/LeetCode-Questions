/*
PROBLEM:

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0) return list;
        int start = 0;
        int end = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++)
        {
            if(i+1 < nums.length)
            {
                long var1 = nums[i+1];
                long var2 = nums[i];
                if(var1 - var2 > 1)
                {
                    if(start == end)
                    {
                        list.add(nums[i]+"");
                        end++;
                        start = end;
                    }
                    else if(end > start)
                    {
                        System.out.println("fedfvbs");
                        list.add(nums[start]+"->"+nums[end]);
                        end++;
                        start = end;
                    }
                }
                else if(nums[i+1] - nums[i] == 1)
                {
                    end++;
                }
            }
        }
        if(start == end)
            list.add(nums[start]+"");
        else
        {
            list.add(nums[start]+"->"+nums[end]);
         
        }
        return list;
    }
}
