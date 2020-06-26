/*PROBLEM
You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.

Example 1:
Input: "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: "AAABBC"
Output: 188
 
Note:
1 <= tiles.length <= 7
tiles consists of uppercase English letters.
*/
import java.util.HashMap;
class Solution {
    
    public int numPossibilities(HashMap<Character,Integer> hmap, String result, String tiles, HashMap<Character,Integer> possmap, int num)
    {
//        System.out.println(result);
        if(result.length() > tiles.length() || (result.length() > 0 && possmap.get(result.charAt(result.length()-1)) > hmap.get(result.charAt(result.length()-1))))
            return num;
        
        Set entrySet = hmap.entrySet();
        Iterator it =  entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if(possmap.get((char)mentry.getKey())+1 <= hmap.get((char)mentry.getKey()))
            {
                possmap.put((char)mentry.getKey(),possmap.get((char)mentry.getKey())+1);
                num = numPossibilities(hmap, result+(char)mentry.getKey(),tiles,possmap,num+1);
                possmap.put((char)mentry.getKey(),possmap.get((char)mentry.getKey())-1);
                
            }
        }
        return num;
    }
    
    public int numTilePossibilities(String tiles) {
        Solution funcs = new Solution();
        HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> possmap = new HashMap<Character,Integer>();
        
        for(int i = 0; i < tiles.length(); i++)
        {
            if(hmap.containsKey(tiles.charAt(i)) == false)
            {
                hmap.put(tiles.charAt(i),1);
                possmap.put(tiles.charAt(i),0);
            }
            else
                hmap.put(tiles.charAt(i),hmap.get(tiles.charAt(i))+1);
        }
        
        int val = 0;
        val = funcs.numPossibilities(hmap,"",tiles,possmap,0);
//        System.out.println("VAL: " + val);
        return val;
    }
}
