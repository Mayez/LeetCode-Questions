/*PROBLEM
A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 
Note:

S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int end = 0;
        for(int i = 0; i < S.length(); i++)
        {
            if(S.lastIndexOf(S.charAt(i)) > end)
                end = S.lastIndexOf(S.charAt(i));
            else if(i == end)
            {
                list.add(end-start+1);
                if(end + 1 < S.length())
                {
                    end++;
                    start = end;
                }
                else
                    break;
            }
        }
        
        
        return list;
    }
}
