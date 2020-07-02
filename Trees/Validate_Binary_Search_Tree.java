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
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
*/

import java.util.Collections;
class Solution {
    
    public boolean allPaths(TreeNode root, ArrayList<Integer> vals,ArrayList<String> dir,boolean state)
    {
        if(root == null)
            return state;
        
        if(root.left != null && root.left.val >= root.val || root.right != null && root.right.val <= root.val)
            state = false;
        
        if(state == true)
        {
            vals.add(root.val);

            if(root.left == null && root.right == null)
            {
//                System.out.println(vals);
//                System.out.println(dir);
                ArrayList<Integer> tempVal = new ArrayList<Integer>(vals);
                ArrayList<String> tempDir = new ArrayList<String>(dir);
                while(tempVal.size() > 1)
                {
                    int diff = 0;
                    int val = tempVal.get(0);
                    if(tempDir.get(0) == "left")
                        diff = -1;
                    else 
                        diff = 1;

                    ArrayList<Integer> tempVal2 = new ArrayList<Integer>(tempVal);
                    Collections.sort(tempVal2);
                    if(diff == 1)
                    {
                        if(tempVal2.get(0) != val || tempVal2.get(0) == val && tempVal2.get(1) == val)
                        {
                            state = false;
                            break;
                        }
                    }
                    else
                    {
                        if(tempVal2.get(tempVal2.size()-1) != val || tempVal2.get(tempVal2.size()-1) == val && tempVal2.get(tempVal2.size()-2) == val)
                        {
                            state = false;
                            break;
                        }
                    }

                    tempVal.remove(0);
                    tempDir.remove(0);
                }
            }
            else
            {

                dir.add("left");
                if(state == true)
                    state = allPaths(root.left,new ArrayList<Integer>(vals),new ArrayList<String>(dir),state);
                dir.remove(dir.size()-1);
                dir.add("right");
                if(state == true)
                    state = allPaths(root.right,new ArrayList<Integer>(vals),new ArrayList<String>(dir),state);
            }
        }
        return state;
    }
        
    public boolean isValidBST(TreeNode root) {
        Solution funcs = new Solution();
        boolean state = funcs.allPaths(root,new ArrayList<Integer>(),new ArrayList<String>(),true);
//        System.out.println(state);
//        funcs.middle(root);
        return state;
    }
}
