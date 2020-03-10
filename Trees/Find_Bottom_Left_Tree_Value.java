/*PROBLEM
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
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
    
    public ArrayList<Integer> printGivenLevel(TreeNode root, int level,ArrayList<Integer> list)
    {
        if(root == null)
            return list;
        if(level == 1)
            list.add(root.val);
        else if(level > 1)
        {
            list = printGivenLevel(root.left,level-1,list);
            list = printGivenLevel(root.right,level-1,list);
        }
        return list;
    }
    
    public ArrayList<Integer> printLevelOrder(TreeNode root,ArrayList<Integer> list)
    {
        int h = height(root);
        list = printGivenLevel(root,h,list);
        return list;
    }
    
    public int findBottomLeftValue(TreeNode root)
    {
        Solution tree = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list = tree.printLevelOrder(root,list);
        System.out.println("LIST: " + list);
        return list.get(0);
    }
}
