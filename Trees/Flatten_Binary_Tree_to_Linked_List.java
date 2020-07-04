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
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/
import java.io.*;
import java.util.*;
class Solution {
    
    public Stack<TreeNode> deconst(TreeNode root, Stack<TreeNode> stack)
    {
        if(root == null)
            return stack;
        
        stack = deconst(root.right,stack);
        stack = deconst(root.left,stack);
        stack.push(root);
        root.left = null;
        return stack;
    }
    
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Solution funcs = new Solution();
        stack = funcs.deconst(root,stack);
        root = stack.pop();
        while(!stack.isEmpty())
        {
            root.right = stack.pop();
            root = root.right;
        }
        return;
    }
}
