/*PROBLEM
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

Example 1:
Input: [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: [2,2,2,5,2]
Output: false
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
    
    public ArrayList<Integer> printGivenLevel(TreeNode root, int level, ArrayList<Integer> list)
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
    
    public boolean printLevelOrder(TreeNode root)
    {
        int h = height(root);
        int val = root.val;
        for(int i = 0; i <= h; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            printGivenLevel(root,i,list);
            if(i > 0)
            {
                list.removeAll(Arrays.asList(val));
                if(list.size() > 0)
                    return false;
            }
        }
        return true;
        
    }
    
    public boolean isUnivalTree(TreeNode root) {
        Solution tree = new Solution();
        boolean state = tree.printLevelOrder(root);
        return state;
    }
}
