/*PROBLEM
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        else
        {
            int ldepth = height(root.left);
            int rdepth = height(root.right);
            if(ldepth > rdepth)
                return ldepth+1;
            return rdepth+1;
        }
    }
    
    public int maxDepth(TreeNode root) {
        Solution tree = new Solution();
        return tree.height(root);
    }
}
