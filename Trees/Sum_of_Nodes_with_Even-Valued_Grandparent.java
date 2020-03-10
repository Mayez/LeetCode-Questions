/*
Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.

Example 1:
Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
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
    
    public int height(TreeNode node)
    {
        if(node == null)
            return 0;
        else
        {
            int lheight = height(node.left);
            int rheight = height(node.right);
            
            if(lheight > rheight)
                return (lheight+1);
            return (rheight+1);
        }
    }
    
    public int printGivenLevel(TreeNode root, int level,int count)
    {
        if(root == null)
            return count;
        if(level == 1 && root.val % 2 == 0)
        {
            if(root.left != null)
            {
                System.out.println("ROOT: " + root.val);
                if(root.left.left != null)
                {
                    count += root.left.left.val;
                    System.out.println("LL: " + root.left.left.val);
                }
                if(root.left.right != null)
                {
                    count += root.left.right.val;
                    System.out.println("LR: " + root.left.right.val);
                }
            }
            if(root.right != null)
            {
                if(root.right.left != null)
                {
                    count += root.right.left.val;
                    System.out.println("RL: " + root.right.left.val);
                }
                if(root.right.right != null)
                {
                    count += root.right.right.val;
                    System.out.println("RR: " + root.right.right.val);                
                }
            }
            System.out.println("count: " + count);
        }
        else if(level > 1)
        {
            count = printGivenLevel(root.left,level-1,count);
            count = printGivenLevel(root.right,level-1,count);
        }
        return count;
    }
    
    
    public int printLevelOrder(TreeNode root, int count)
    {
        int total = 0;
        int h = height(root);
        int i;
        for(i = 1; i <= h; i++)
        {
            total += printGivenLevel(root,i,count);
        }
        return total;
    }
    
    
    public int sumEvenGrandparent(TreeNode root) {
        Solution tree = new Solution();
//        tree.treeTrav(root);
        int total = 0;
        int count = 0;
        total = tree.printLevelOrder(root,count);
        System.out.println(total);
        return total;
    }
}
