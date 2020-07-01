/*PROBLEM
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    
    ArrayList<List<Integer>> listOfLists = new ArrayList<List<Integer>>();    
    public ArrayList<List<Integer>> possibilities(int[] nums,int level,boolean[] visited, ArrayList<Integer> list, ArrayList<List<Integer>> listOfLists)
    {
        if(level == nums.length+1 || listOfLists.contains(list) == true)
        {
            return listOfLists;
        }
        else if(listOfLists.contains(list) == false)
            listOfLists.add(new ArrayList<Integer>(list));
//        System.out.println(list);
        
        for(int i = 0; i < nums.length; i++)
        {
            if(visited[i] == false)
            {
                list.add(nums[i]);
                Collections.sort(list);
                visited[i] = true;
//                System.out.println("LISTS Before: " + listOfLists);
                listOfLists = possibilities(nums,level+1,visited,list,listOfLists);
//                System.out.println("LISTS After: " + listOfLists);
                visited[i] = false;
                list.remove(list.indexOf(nums[i]));
            }
        }
        
        return listOfLists;
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        
        Solution funcs = new Solution();
        ArrayList<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if(nums.length == 1)
        {
            list.add(nums[0]);
            listOfLists.add(new ArrayList<Integer>());
            listOfLists.add(new ArrayList<Integer>(list));        
        }
        else
            listOfLists = funcs.possibilities(nums,0,visited,list,listOfLists);
        return listOfLists;
    }
}
