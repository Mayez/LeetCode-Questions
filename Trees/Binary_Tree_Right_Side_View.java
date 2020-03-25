/*PROBLEM
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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
    
    public ArrayList<Integer> printGivenLevel(TreeNode root, int level,ArrayList<Integer> list)
    {
        if(root == null)
            return list;
        if(level == 1)
            list.add(root.val);
        else if(level > 1)
        {
            list = printGivenLevel(root.left, level-1,list);
            list = printGivenLevel(root.right,level-1,list);
        }
        return list;
    }
    
    public ArrayList<Integer> printLevelOrder(TreeNode root)
    {
        int h = height(root);
        ArrayList<Integer> finalList = new ArrayList<>();
        for(int i = 1; i <= h; i++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            list = printGivenLevel(root,i,list);
            if(list.size() > 0)
                finalList.add(list.get(list.size()-1));
        }
        System.out.println("LIST: " + finalList);
        return finalList;
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<Integer> list = new ArrayList<>();
        list = tree.printLevelOrder(root);
        return list;
    }
}
