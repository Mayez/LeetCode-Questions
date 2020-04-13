/*PROBLEM
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:
Input: 3
Output: "III"

Example 2:
Input: 4
Output: "IV"

Example 3:
Input: 9
Output: "IX"

Example 4:
Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 5:
Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
import java.lang.Math;
class Solution {
    public String intToRoman(int num) {
        String roman = "";
        char[] str = Integer.toString(num).toCharArray();
        String[] oneNine ={"I","II","III","IV","V","VI","VII","VIII","IX"};
        for(int i = 0; i < str.length; i++)
        {
            double val = Integer.parseInt(String.valueOf(str[i])) * Math.pow(10,(str.length-1 - i));
            int val1 = (int)Math.round(val);
            System.out.print(val1 + " ");
            if(val1 < 10 && val1 > 0)
                roman += oneNine[val1-1];
            else if(val1 <= 30)
            {
                for(int j = 0; j < val1/10; j++)
                    roman += "X";
            }
            else if(val1 == 40)
                roman += "XL";
            else if(val1 >= 50 && val1 <= 80)
            {
                roman += "L";
                if(val1 >= 60)
                {
                    for(int m = 0; m < (val1-50)/10; m++)
                        roman += "X";
                }
            }
            else if(val1 == 90)
                roman += "XC";
            else if(val1 == 400)
                roman += "CD";
            else if(val1 >= 500 && val1 <= 800)
            {
                roman += "D";
                if(val1 >= 600)
                {
                    for(int n = 0; n < (val1-500)/100; n++)
                        roman += "C";
                }
            }
            else if(val1 == 900)
                roman += "CM";
            else if(val1 <= 300)
            {
                for(int k = 0; k < val1/100; k++)
                    roman += "C";
            }
            else if(val1 <= 3000)
            {
                for(int j = 0; j < val1/1000; j++)
                    roman += "M";
            }
        }
        return roman;
    }
}
