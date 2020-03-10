/*PROBLEM
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
    public ArrayList<Integer> traversal(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null)
            return list;
        
        list = traversal(root.left,list);
        list.add(root.val);
        list = traversal(root.right,list);
        return list;
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        Solution tree = new Solution();
        ArrayList <Integer> list = new ArrayList<>();
        list = tree.traversal(root,list);
        return list;
    }
}
