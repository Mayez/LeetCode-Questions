/*PROBLEM
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:
Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
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
    public ArrayList<Integer> traversal(TreeNode root,ArrayList<Integer> list)
    {
        if(root == null)
            return list;
        
        list = traversal(root.left,list);
        System.out.println(root.val);
        list.add(root.val);
        list = traversal(root.right,list);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        Solution tree = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list = tree.traversal(root,list);
        
        return list.get(k-1);
    }
}
