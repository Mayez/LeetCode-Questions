/*PROBLEM
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
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
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            if(lheight > rheight)
                return (lheight+1);
            return (rheight+1);
        }
    }
    
    public int printGivenLevel(TreeNode root, int level, int val)
    {
        if(root == null)
            return val;
        if(level == 1)
            val++;
        else if(level > 1)
        {
            val = printGivenLevel(root.left,level-1,val);
            val = printGivenLevel(root.right,level-1,val);
        }
        return val;
    }
    
    public int printLevelOrder(TreeNode root)
    {
        int h = height(root);
        int val = 0;
        for(int i = 0; i <= h; i++)
        {
            val = printGivenLevel(root,i,val);
        }
        return val;
    }
    
    public int countNodes(TreeNode root) {
        Solution tree = new Solution();
        int val = tree.printLevelOrder(root);
        System.out.println("VAL: " + val);
        return val;
    }
}
