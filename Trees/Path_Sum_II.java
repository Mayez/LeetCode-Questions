/*PROBLEM
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

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
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Solution tree = new Solution();
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        listOfLists = tree.traversal(root,new ArrayList(),listOfLists);
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for(int i = 0; i < listOfLists.size(); i++)
        {
            int val = 0;
            for(int j = 0; j < listOfLists.get(i).size(); j++)
            {
                val += listOfLists.get(i).get(j); 
            }
            if(val == sum)
                finalList.add(listOfLists.get(i));
        }
        System.out.println("FINAL: " + finalList);
        return finalList;
    }
}
