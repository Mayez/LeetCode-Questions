/*PROBLEM
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

class Solution {
    public ArrayList<ArrayList<Integer>> traversal(TreeNode root, ArrayList<Integer> list,ArrayList<ArrayList<Integer>> listOfLists)
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
    
    public List<String> binaryTreePaths(TreeNode root) {
        Solution tree = new Solution();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<>();
        listOfLists = tree.traversal(root,new ArrayList(),listOfLists);
        System.out.println("LISTS: " + listOfLists);
        ArrayList<String> listStr = new ArrayList<>();
        for(int i = 0; i < listOfLists.size(); i++)
        {
            String s = "";
            for(int j = 0; j < listOfLists.get(i).size(); j++)
            {
                s += String.valueOf(listOfLists.get(i).get(j));
                if(j < listOfLists.get(i).size()-1)
                    s += "->"; 
            }
            System.out.println("STR: " + s);
            listStr.add(s);
        }
        return listStr;
    }
}
