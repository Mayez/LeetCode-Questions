/*PROBLEM
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> n = new HashMap<>();
        String str = "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            if(n.containsKey(s.charAt(i)) == false)
                n.put(s.charAt(i),1);
            else if(n.containsKey(s.charAt(i)) != false)
                n.put(s.charAt(i),n.get(s.charAt(i))+1);
        }
        
        System.out.println(n);
        int count = n.size();
        for(int j = 0; j < count; j++)
        {
            int max = Collections.max(n.values());
            Set entrySet = n.entrySet();
            Iterator it = entrySet.iterator();
            char c = ' ';
            while(it.hasNext())
            {
                Map.Entry mentry = (Map.Entry)it.next();
                if((int)mentry.getValue() == max && str.indexOf((char)mentry.getKey()) == -1)
                {
                    c = (char)mentry.getKey();
                    System.out.println(c);
                    for(int k = 0; k < max; k++)
                        str += c;
                    break;
                }
            }
            n.remove(c);
        }
        
        if(n.size() == 1 && str.indexOf((char)n.entrySet().iterator().next().getKey()) == -1)
        {
            int value = n.entrySet().iterator().next().getValue();
            int key = n.entrySet().iterator().next().getKey();
            System.out.println("KEY: " + key);
            System.out.println("VAL: " + value);
            for(int m = 0; m < value; m++)
                str += (char)key;
        }
        return str;
    }
}
