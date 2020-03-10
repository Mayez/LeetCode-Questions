/*PROBLEM
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.

For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Note:

Both of the given trees will have between 1 and 100 nodes.
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
    public ArrayList<Integer> traversal(TreeNode root, ArrayList<Integer> n)
    {
        if(root == null)
            return n;
        if(root.left == null && root.right == null)
            n.add(root.val);

        n = traversal(root.left,n);
        n = traversal(root.right,n);
        return n;
    }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Solution tree = new Solution();
        ArrayList <Integer> m = new ArrayList<>();
        ArrayList <Integer> n = new ArrayList<>();
        m = tree.traversal(root1,m);
        n = tree.traversal(root2,n);
        System.out.println(n);
        System.out.println(m);
        if(n.size() != m.size())
            return false;
        for(int i = 0; i < n.size(); i++)
        {
            if(n.get(i) != m.get(i))
                return false;
        }
        return true;
    }
}
