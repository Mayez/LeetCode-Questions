/*PROBLEM
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:
Input: 123
Output: "One Hundred Twenty Three"

Example 2:
Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

import java.lang.Integer.*;
class Solution {
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String s = String.valueOf(num);
        String threeSplit = "";
        String[] engRepOnes = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                              "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
                              "Seventeen","Eighteen","Nineteen"};
        String[] engRepTens = {"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] engRepOther = {"Thousand","Million","Billion"};
        ArrayList<String> list = new ArrayList<String>();
        for(int i = s.length()-1; i >= 0; i--)
        {
            threeSplit += s.charAt(i);
            if(((s.length())-i) % 3 == 0)
            {
//                System.out.println(threeSplit);
                list.add(threeSplit);
                threeSplit = "";
            }
        }
 //       System.out.print(threeSplit);
        if(threeSplit.equals("") == false)
            list.add(threeSplit);
        
        String ans = "";
        for(int j = 0; j < list.size(); j++)
        {
            String t = "";
            String finalStr = "";
            for(int k = 0; k < list.get(j).length(); k++)
            {
                t = list.get(j).charAt(k) + t;
                if(t.length() == 1 || t.length() == 3)
                {
                    if(t.length() == 3 && (int)list.get(j).charAt(k)-48 > 0)
                    {
           //             System.out.print(" " + engRepOther[0]);
                        finalStr = "Hundred" + finalStr;
                    }
      //              System.out.print(engRepOnes[((int)list.get(0).charAt(k)-48)-1]);
                    if((int)list.get(j).charAt(k)-48 > 0)
                        finalStr = engRepOnes[((int)list.get(j).charAt(k)-48)-1] + finalStr;
        //            System.out.println();
                }
                else if(t.length() == 2)
                {
                    if(Integer.valueOf(t) > 19)
                    {
      //                  System.out.println(engRepTens[((int)list.get(0).charAt(k)-48)-2]);
                        finalStr = engRepTens[((int)list.get(j).charAt(k)-48)-2] + finalStr;
                    }
                    else if(Integer.valueOf(t) > 0)
                    {
    //                    System.out.println(engRepOnes[Integer.valueOf(t)-1]);
                        finalStr = engRepOnes[Integer.valueOf(t)-1];
                    }

                }

            }
            if(j > 0 && Integer.valueOf(t) > 0)
                finalStr += engRepOther[j-1];

    //        System.out.println(t);
            finalStr = finalStr.replaceAll("([A-Z])", " $1");
//            if(finalStr.length() > 0)
//                finalStr = finalStr.substring(1);
//            System.out.println("FINAL: \'" + finalStr + "\'");
            if(finalStr.length() != 0)
                ans = finalStr + ans;
        }
        ans = ans.substring(1);
//        System.out.println(ans);
//        System.out.println(list);
        return ans;
    }
}
