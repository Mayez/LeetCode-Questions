/*PROBLEM
Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:

Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 
Note:

1 <= paragraph.length <= 1000.
0 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.
*/
import java.util.Hashtable;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        for(int i = 0; i < banned.length; i++)
        {
//            System.out.println("BANNED: " + banned[i]);
            paragraph = paragraph.replaceAll(banned[i],"");
//            System.out.println(paragraph);
        }
        paragraph = paragraph.replaceAll("[!?',;.]"," ");
        paragraph = paragraph.replaceAll("[ ]{2,}", " ");
//        System.out.println(paragraph);
        
        String[] splitStr = paragraph.trim().split("\\s+");
        Hashtable<String,Integer> n = new Hashtable<String,Integer>();
        for(int j = 0; j < splitStr.length; j++)
        {
//            System.out.println(splitStr[j]);
            if(n.containsKey(splitStr[j]) == false)
                n.put(splitStr[j],1);
            else if(n.containsKey(splitStr[j]) == true)
                n.put(splitStr[j],n.get(splitStr[j])+1);
        }
        
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        int max = 0;
        String finalStr = "";
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if((Integer)mentry.getValue() > max)
            {
                max = (Integer)mentry.getValue();
                finalStr = (String)mentry.getKey();
            }
  //          System.out.println((String)mentry.getKey());
  //          System.out.println((Integer)mentry.getValue());
        }
        
 //       System.out.println("VAL: " + max);
  //      System.out.println("STR: " + finalStr);        
//        System.out.println(n);       
        return finalStr;
    }
}
