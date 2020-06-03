/*PROBLEM
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

import java.lang.Math;
import java.lang.Integer;
class Solution {
    public int reverse(int x) {
        if(x == -2147483648)
            return 0;
        
        String s = "";
        
        if(x < 0)
        {
            s+= "-";
            x*= -1;
        }
        
        int zeroFlag = 0;
        while(x > 0)
        {
            if(x%10 != 0)
                zeroFlag = 1;
            if(zeroFlag == 1)
                s+= String.valueOf(x%10);
            x = x/10;
        }
        
        int num = 0;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i) == '-')
            {
                num *= -1;
                break;
            }
            else if(num  + ((int)s.charAt(i)-48)*Math.pow(10,s.length()-1-i) <= Integer.MAX_VALUE)
            {
                num += ((int)s.charAt(i)-48)*Math.pow(10,s.length()-1-i);
            }
            else if(num  + ((int)s.charAt(i)-48)*Math.pow(10,s.length()-1-i) > Integer.MAX_VALUE)
                return 0;
        }
        
//        System.out.println(s);
//        System.out.println(num);
        return num;
    }
}
