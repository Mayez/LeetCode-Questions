/*PROBLEM
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:
Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
 
Note:

The number of nodes in the given tree is between 1 and 10^4.
-10^5 <= node.val <= 10^5
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
    
    public ArrayList<Integer> printGivenLevel(TreeNode root, int level, ArrayList<Integer>list)
    {
        if(root == null)
            return list;
        if(level == 1)
            list.add(root.val);
        else if(level > 1)
        {
            list = printGivenLevel(root.left, level-1,list);
            list = printGivenLevel(root.right, level-1,list);
        }
        return list;
    }
    
    public ArrayList<ArrayList<Integer>> printLevelOrder(TreeNode root)
    {
        int h = height(root);
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        for(int i = 1; i <= h; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list = printGivenLevel(root,i,list);
            listOfLists.add(list);
        }
        return listOfLists;
    }
    
    public int maxLevelSum(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        listOfLists = tree.printLevelOrder(root);
        int level = 0;
        int maxVal = 0;
        for(int i = 0; i < listOfLists.size(); i++)
        {
            int count = 0;
            for(int j = 0; j < listOfLists.get(i).size(); j++)
            {
                count += listOfLists.get(i).get(j);
            }
            if(count > maxVal)
            {
                maxVal = count;
                level = i+1;
            }
        }
        
        return level;
    }
}
