/*PROBLEM
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true
Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
*/
class Solution {
    public boolean isValid(String s) {
        Stack <Character> n = new Stack<>();
        String dup = s;
        while(dup.contains("()") || dup.contains("{}") || dup.contains("[]"))
        {
            String test = "";
            int count = 0;
            while(count < dup.length())
            {
                if(count+1 < dup.length() && (dup.charAt(count) == '(' && dup.charAt(count+1) == ')' ||
                dup.charAt(count) == '[' && dup.charAt(count+1) == ']' || dup.charAt(count) == '{' && dup.charAt(count+1) == '}'))
                {
                    n.push(dup.charAt(count));
                    n.push(dup.charAt(count+1));
                    count += 2;
                }
                else
                {
                    test += dup.charAt(count);
                    count++;
                }
            }
            dup = test;
        }
        if(dup.length() == 0)
            return true;
        return false;
    }
}
