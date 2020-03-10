/*PROBLEM
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
import java.util.*;
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> n = new HashMap<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(n.containsKey(s.charAt(i)) == false)
                n.put(s.charAt(i),1);
            else if(n.containsKey(s.charAt(i)) != false)
                n.put(s.charAt(i),n.get(s.charAt(i))+1);
        }
        System.out.println(n);
        
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        int val = s.length()-1;
        int flag = 0;
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if((int)mentry.getValue() == 1)
            {
                flag = 1;
                if(s.indexOf((char)mentry.getKey()) < val)
                   val = s.indexOf((char)mentry.getKey());
            }
        }
        
        if(flag == 0)
            return -1;
        
        return val;
    }
}
