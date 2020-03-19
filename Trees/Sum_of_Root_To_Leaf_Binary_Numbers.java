/*PROBLEM
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

Example 1:
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

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
    public ArrayList<ArrayList<Integer>> traversal(TreeNode root,ArrayList<Integer> list, ArrayList<ArrayList<Integer>>listOfLists)
    {
        if(root == null)
            return listOfLists;
        
        list.add(root.val);

        if(root.left == null && root.right == null)
        {
            listOfLists.add(list);
        }
        else
        {
            listOfLists = traversal(root.left,new ArrayList(list),listOfLists);
            listOfLists = traversal(root.right,new ArrayList(list),listOfLists);
        }
        return listOfLists;
    }
    
    
    public int sumRootToLeaf(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        listOfLists = tree.traversal(root,new ArrayList(),listOfLists);
        int total = 0;
        for(int i = 0; i < listOfLists.size(); i++)
        {
            int val = 0;
            for(int j = listOfLists.get(i).size()-1; j >= 0; j--)
            {
                System.out.print(listOfLists.get(i).get(j));
                val += Math.pow(2,listOfLists.get(i).size()-1-j) * listOfLists.get(i).get(j); 
            }
            total += val;
            System.out.println();
            System.out.println("VAL: " + val);
        }
        return total;
    }
}
