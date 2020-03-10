/*PROBLEM
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
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
import java.util.*;
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
        {
            list.add(root.val);
            System.out.print(root.val);
        }
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
        ArrayList<Integer> levelList = new ArrayList<>();
        for(int i = 0; i <= h; i++)
        {
            levelList = printGivenLevel(root,i,levelList);
            Collections.sort(levelList);
            if(levelList.size() > 0)
                list.add(levelList.get(levelList.size()-1));
            levelList.clear();
            System.out.println();
        }
        return list;
    }
    public List<Integer> largestValues(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list = tree.printLevelOrder(root,list);
        return list;
    }
}
