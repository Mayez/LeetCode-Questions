/*PROBLEM
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
    public String decodeString(String s) {
        String dup = s;
        for(int i = 0; i < s.length(); i++)
        {
            if((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57)
            {
                String identifier = "";
                String num = "";
                while((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57)
                {
                    identifier += s.charAt(i);
                    num += s.charAt(i);
                    i++;
                }
                identifier += "[";
                int count = i+1;
                int difference = 1;
                String variable = "";
                while(difference != 0 && count < s.length())
                {
                    if(s.charAt(count) == '[')
                        difference++;
                    else if(s.charAt(count) == ']')
                        difference--;
                    if(difference != 0)
                    {
                        variable += s.charAt(count);
                        identifier += s.charAt(count);
                    }
                    count++;
                }
                identifier += "]";
                String inserting = dup.replace(identifier,variable.repeat(Integer.parseInt(num)));
                dup = inserting;
            }
        }
        return dup;
    }
}
