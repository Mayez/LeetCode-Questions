/*PROBLEM
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public ArrayList<Integer> traversal(TreeNode root,ArrayList<Integer> list)
    {
        if(root == null)
            return list;
        
        list.add(root.val);
        list = traversal(root.left,list);
        list = traversal(root.right,list);
        
        return list;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Solution tree = new Solution();
        ArrayList <Integer> list = new ArrayList<Integer>();
        list = tree.traversal(root1,list);
        list = tree.traversal(root2,list);
        Collections.sort(list);
        System.out.println(list);
        return list;
    }
}
