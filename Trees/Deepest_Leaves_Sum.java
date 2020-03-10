/*PROBLEM
Given a binary tree, return the sum of values of its deepest leaves.
 
Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
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
    
    public int printGivenLevel(TreeNode node, int level,int count)
    {
        if(node == null)
            return count;
        if(level == 1)
        {
            System.out.println(node.val);
            count += node.val;
        }
        else if(level > 1)
        {
            count = printGivenLevel(node.left,level-1,count);
            count = printGivenLevel(node.right,level-1,count);
        }
        return count;
    }
    
    public int height(TreeNode node)
    {
        if(node == null)
            return 0;
        else
        {
            int ldepth = height(node.left);
            int rdepth = height(node.right);
            if(ldepth > rdepth)
                return (ldepth+1);
            return (rdepth+1);
        }
    }
    
    public int printLevelOrder(TreeNode root, int count)
    {
        int h = height(root);
        int counter = printGivenLevel(root,h,count);
        return counter;
    }
    
    public int deepestLeavesSum(TreeNode root) {
        Solution tree = new Solution();
        int count = 0;
        int height = tree.height(root);
        System.out.println("HEIGHT: " + height);
        count = tree.printLevelOrder(root,count);
        System.out.println("COUNT: " + count);
        return count;
    }
}
