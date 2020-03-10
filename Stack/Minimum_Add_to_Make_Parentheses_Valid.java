/*PROBLEM
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

Example 1:
Input: "())"
Output: 1

Example 2:
Input: "((("
Output: 3

Example 3:
Input: "()"
Output: 0

Example 4:
Input: "()))(("
Output: 4
*/
import java.lang.*;
class Solution {
    public int minAddToMakeValid(String S) {
        if(S.length() == 0)
            return 0;
        String test = S;
        Stack <Character> n = new Stack<>();
        while(test.contains("()"))
        {
            String test1 = test;
            test = "";
            int count = 0;
            while(count < test1.length())
            {
                if((count + 1) < test1.length() && test1.charAt(count) == '(' && test1.charAt(count+1) == ')')
                {
                    n.push(test1.charAt(count));
                    n.push(test1.charAt(count+1));
                    count += 2;   
                }
                else
                {
                    test += test1.charAt(count);
                    count++;
                }
            }
        }
        System.out.println(n);
        System.out.println(test);
        return test.length();
    }
}
