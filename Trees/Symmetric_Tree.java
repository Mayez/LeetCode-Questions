/*PROBLEM
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
        {
            list.add(null);
            return list;
        }
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
        for(int i = 1; i <= h; i++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            list = printGivenLevel(root,i,list);
            if(i > 1)
            {
                for(int j = 0; j < (list.size()/2); j++)
                {   
                    if(list.get((list.size()/2)-1-j) != list.get((list.size()/2)+j))
                        return false;
                }
            }
        }
        return true;
    }
    
    public boolean isSymmetric(TreeNode root) {
        Solution tree = new Solution();
        boolean state = false;
        state = tree.printLevelOrder(root);
        System.out.println("STATE: " + state);
        return state;
    }
}
