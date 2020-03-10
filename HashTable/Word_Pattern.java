/*PROBLEM
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String dup = str;
        String[] list = dup.split(" ");

        if(list.length == 1)
        {
            if(Character.toString(list[0].charAt(0)).equals(pattern) || pattern.length() == list.length)
                return true;
            else
                return false;
        }
        int count = 0;
        HashMap <Character,String> n = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++)
        {
            if(n.containsKey(pattern.charAt(i)) == false && n.containsValue(list[i]) == false)
            {
                n.put(pattern.charAt(count),list[i]);
            }
            count++;
        }
        
        System.out.println(n);
        String newStr = "";
        for(int j = 0; j < pattern.length(); j++)
        {
            newStr += n.get(pattern.charAt(j));
            if(j < pattern.length()-1)
                newStr += " ";

        }
        
        System.out.println("\"" + newStr + "\"");  
        System.out.println("\"" + str + "\"");
        return newStr.equals(str);
    }
}
