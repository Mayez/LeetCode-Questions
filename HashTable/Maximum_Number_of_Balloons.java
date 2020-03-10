/*PROBLEM
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0
*/
import java.util.*;
class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> n = new HashMap<>();
        int index = 0;
        for(int i = 0; i < text.length(); i++)
        {
            if(n.containsKey(text.charAt(i)) == false)
                n.put(text.charAt(i),1);
            else if(n.containsKey(text.charAt(i)) != false)
                n.put(text.charAt(i),n.get(text.charAt(i))+1);
        }
        System.out.println(n);
        int count = 0;
        if(n.containsKey('b') == true && n.containsKey('a') == true && n.containsKey('l') == true && n.containsKey('o') == true && n.containsKey('n') == true)
        {
            while(true)
            {
                if(n.get('b')-1 >= 0 && n.get('a')-1 >= 0 && n.get('l')-2 >= 0 && n.get('o')-2 >= 0 && n.get('n')-1 >= 0)
                {
                    count++;
                    n.put('b',n.get('b')-1);
                    n.put('a',n.get('a')-1);
                    n.put('l',n.get('l')-2);
                    n.put('o',n.get('o')-2);
                    n.put('n',n.get('n')-1);
                }
                else
                    break;
            }
        }
        return count;
    }
}
