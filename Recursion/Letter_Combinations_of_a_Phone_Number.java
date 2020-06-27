Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

class Solution {
    
    public List<String> possibilities(String digits, char[] ref,String str,int index, List<String> list)
    {
        if(str.length() == digits.length())
        {
            list.add(str);
            return list;
        }
        
//        System.out.println(str);
        int length = 0;
        if(digits.charAt(index) == '9')
            length = 4;
        else
        {
            length = ref[digits.charAt(index)-48-1] - ref[digits.charAt(index)-48-2]; 
        }

//        System.out.println("LENGTH: " + length);
        for(int i = 0; i < length; i++)
        {
            char c = (char)((int)ref[digits.charAt(index)-48-2]+i);
/*            if(digits.length() > 1 && str.length() >= 1 || digits.length() == 1 && str.length() == 0)
            {
                list.add(str+c);
                System.out.println(str+c);
            }*/
            if(index+1 <= digits.length())
                list = possibilities(digits,ref,str+c,index+1,list);
        }
        
        return list;
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<String>();
        if(digits.length() == 0)
            return list;
        char[] ref = new char[]{'a','d','g','j','m','p','t','w'};
        Solution funcs = new Solution();
        list = funcs.possibilities(digits,ref,"",0,list);
        return list;
    }
}
