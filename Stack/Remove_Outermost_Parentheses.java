/*PROBLEM
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Example 1:
Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Example 2:
Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Example 3:
Input: "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
*/
class Solution {
    public String removeOuterParentheses(String S) {
        int difference = 0;
        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++)
        {
            if(difference == 0 && S.charAt(i) == '(')
            {
                list.add(i);
                System.out.println("I: " + i);
            }
            if(S.charAt(i) == '(')
                difference++;
            else if(S.charAt(i) == ')')
                difference--;
            if(difference == 0 && S.charAt(i) == ')')
            {
                list.add(i);
                System.out.println("I: " + i);
                continue;
            }
        }
        
        String test = "";
        for(int j = 0; j < S.length(); j++)
        {
            if(list.contains(j) == false)
                test += S.charAt(j);
        }
        return test;
    }
}
