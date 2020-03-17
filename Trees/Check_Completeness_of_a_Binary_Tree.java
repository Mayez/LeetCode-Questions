/*PROBLEM
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example 1:
Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.
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

import java.lang.Math;
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
    
    public ArrayList printGivenLevel(TreeNode root, int level, ArrayList list)
    {
        if(root == null)
        {
            list.add(null);
            return list;
        }
       if(level == 1)
            list.add(root.val);
        else if(level > 1)
        {
            list = printGivenLevel(root.left, level-1, list);
            list = printGivenLevel(root.right,level-1, list);
        }
        return list;
    }
    
    public boolean printLevelOrder(TreeNode root)
    {
        int h = height(root);
        for(int i = 0; i <= h; i++)
        {
            ArrayList list = new ArrayList();
            list = printGivenLevel(root,i,list);
            if(i > 0 && i < h && list.contains(null) == true)
                return false;
            if(i == h)
            {
                if(list.contains(null) == false)
                    return true;
                int pos = list.indexOf(null);
                for(int j = pos+1; j < list.size(); j++)
                {
                    if(list.get(j) != null)
                        return false;
                }
            }
            System.out.println("LIST: " + list);
            
        }
        return true;
    }
    
    public boolean isCompleteTree(TreeNode root) {
        Solution tree = new Solution();
        boolean state = tree.printLevelOrder(root);
        System.out.println("STATE: " + state);
        return state;
    }
}
