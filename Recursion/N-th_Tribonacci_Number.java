/*PROBLEM
The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:
Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

Example 2:
Input: n = 25
Output: 1389537
 
Constraints:
0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.

*/
class Solution {
    public ArrayList<Integer> recursive(ArrayList<Integer> list, int count, int n)
    {
        int counter = 0;
        for(int i = 0; i < list.size(); i++)
            counter+= list.get(i);
        list.add(counter);
        list.remove(0);
        if(count == n)
            return list;
        recursive(list,count+1,n);
        return list;
    }
    
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1 || n == 2)
            return 1;
        Solution funcs = new Solution();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0); list.add(1); list.add(1);
        list = funcs.recursive(list,3,n);
        return list.get(list.size()-1);
    }
}
