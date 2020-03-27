/*PROBLEM
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
                return(lheight+1);
            return(rheight+1);
        }
    }
    
    public ArrayList<Integer> printGivenLevel(TreeNode root, int level,ArrayList<Integer> list)
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
    
    public ArrayList<List<Integer>> printLevelOrder(TreeNode root)
    {
        int h = height(root);
        ArrayList<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        for(int i = 1; i <= h; i++)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list = printGivenLevel(root,i,list);
            listOfLists.add(list);
        }
        return listOfLists;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists = printLevelOrder(root);
        return listOfLists;
    }
}
