/*PROBLEM
You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:
Input: s = "(abcd)"
Output: "dcba"

Example 2:
Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.

Example 3:
Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

Example 4:
Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
*/
class Solution {
    public String reverseParentheses(String s) {
        int count = 0;
        while(s.indexOf("()") != -1)
            s = s.replace("()","");
        
        while(count < s.length() && s.contains("(") && s.contains(")"))
        {
            if(s.charAt(count) == '(' && s.indexOf("()",count) == -1)
            {
                int leftPos = s.indexOf('(',count+1);
                int rightPos = s.indexOf(')',count);
                System.out.println("L: " + leftPos);
                System.out.println("R: " + rightPos);
                if(rightPos < leftPos || rightPos > leftPos && leftPos == -1)
                {
                    StringBuilder line = new StringBuilder();
                    line.append(s.substring(count+1,rightPos));
                    s = s.replace("(" + s.substring(count+1,rightPos)+")",line.reverse());
                    System.out.println(line.reverse());         
                    count = -1;
                }
            }                
            count++;
        }
        System.out.println(s);
        return s;
    }
}
