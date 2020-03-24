/*PROBLEM
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

Example 2:
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
*/
import java.lang.Math;
class Solution { 
    public ArrayList<ArrayList<Integer>> traversal(TreeNode root, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> listOfLists)
    {
        if(root == null)
            return listOfLists;
        list.add(root.val);
        if(root.left == null && root.right == null)
            listOfLists.add(list);
        else
        {
            listOfLists = traversal(root.left,new ArrayList(list),listOfLists);
            listOfLists = traversal(root.right,new ArrayList(list),listOfLists);
        }
        return listOfLists;
    }
    
    public int sumNumbers(TreeNode root) {
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
                val += Math.pow(10,listOfLists.get(i).size()-1-j) * listOfLists.get(i).get(j);
            }
            System.out.println();
            System.out.println("VAL: " + val);
            total += val;
        }
        return total;
    }
}
