/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
/*PROBLEM
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
*/
class Solution {
    
        
    public TreeNode window(int[] arr, int l, int r,TreeNode root)
    {
        if(l <= r && l < arr.length && r >= 0)
        {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for(int i = l; i <= r; i++)
            {
                if(max < arr[i])
                {
                    index = i;
                    max = arr[i];
                }
            }
//            System.out.println("INDEX: " + index);
//            System.out.println("l: " + l);
            root = new TreeNode(max);
            root.left = window(arr,l,index-1,root.left);
//            System.out.println(root.val);
            root.right = window(arr,index+1,r,root.right);
        }
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Solution funcs = new Solution();
        
        int index = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(max < nums[i])
            {
                index = i;
                max = nums[i];
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = funcs.window(nums,0,index-1,root.left);

        root.right = funcs.window(nums,index+1,nums.length-1,root.right);

        
        return root;
    }
}
