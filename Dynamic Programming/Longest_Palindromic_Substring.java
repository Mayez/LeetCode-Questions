class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s;
        else if(s.length() == 2)
        {
            if(s.charAt(0) != s.charAt(1))
                return Character.toString(s.charAt(0));
            else 
                return s;
        }
        else if(s.length() == 3)
        {
            if(s.charAt(0) == s.charAt(2))
                return s;
            else if(s.charAt(0) == s.charAt(1))
                return s.substring(0,2);
            else if(s.charAt(1) == s.charAt(2))
                return s.substring(1,3);
            else
                return Character.toString(s.charAt(0));
        }
        
        String palindrome = "";
        int left =  0;
        int right = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(i > 0 && i+1 < s.length())
            {
                int sameConstant = 1;
                String subStr = "";
                if(s.charAt(i) == s.charAt(i+1)) // even
                {                    
    //                System.out.println("TEST1");
                    subStr += s.charAt(i);
                    subStr += s.charAt(i+1);
                    left = i-1;
                    if(s.charAt(i) == s.charAt(i-1))
                    {
                        if(i > 1 && s.charAt(i-2) != s.charAt(i))
                        {
                            subStr = s.charAt(i-1) + subStr;
                            left = i-2;
                        }
                    }
                    right = i+2;
/*                    if(s.charAt(i) == s.charAt(i-1))
                    {
                        subStr = s.charAt(i-1) + subStr;
                        left = i-2;
                        right = i+2;
                    }*/
                }
                else if(s.charAt(i-1) == s.charAt(i+1)) //odd
                {
     //               System.out.println("TEST2");
                    subStr += s.charAt(i-1);
                    subStr += s.charAt(i);
                    subStr += s.charAt(i+1);                    
                    if(s.charAt(i) != s.charAt(i-1))
                        sameConstant = 0;
                    left = i-2;
                    right = i+2;
                }
                else
                    continue;
//                System.out.println("SUBSTR1: " + subStr);
                
                while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
                {
                    if(subStr.indexOf(s.charAt(left)) == -1 || subStr.indexOf(s.charAt(right)) == -1)
                       sameConstant = 0;
                    subStr += s.charAt(right);
                    subStr = s.charAt(left) + subStr;
                    left--;
                    right++;
                }                

//                System.out.println("SAMECONSTANT: " + sameConstant);
//                System.out.println("LEFT: " + left);
//                System.out.println("RIGHT: " + right);
                
  //              System.out.println("SubStr1: " + subStr);
                
                if(subStr.length() > 0 && left >= 0 && s.charAt(left) == subStr.charAt(subStr.length()-1) && sameConstant == 1)
                {
                    subStr = s.charAt(left) + subStr;
                }
                
                else if(subStr.length() > 0 && right < s.length() && s.charAt(right) == subStr.charAt(0) && sameConstant == 1)
                {
                    subStr += s.charAt(right);
                }
//                if(subStr.length() > 10)
//                    System.out.println("SubStr2: " + subStr);

                if(subStr.length() > palindrome.length())
                {
                    palindrome = subStr;
    //                System.out.println("palindrome: " + palindrome);        
                }
            }
        }
        
//        System.out.println("palindrome: " + palindrome);
        if(palindrome.length() == 0)
            return Character.toString(s.charAt(0));
        return palindrome;
    }
}
