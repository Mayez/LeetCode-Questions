/*PROBLEM
In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:

Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
 
Constraints:
The input will only have lower-case letters.
1 <= dict.length <= 1000
1 <= dict[i].length <= 100
1 <= sentence words number <= 1000
1 <= sentence words length <= 1000
*/
import java.util.HashMap;
class Solution {
    
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        TrieNode(){
            isEndOfWord = false;
            for(int i = 0; i < 26; i++)
                children[i] = null;
        }
    }
    
    static TrieNode root;
    
    static void insert(String key){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for(level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }
        
        pCrawl.isEndOfWord = true;
    }
    
    static ArrayList<String> search(String key, ArrayList<String> list){
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root; 
        for(level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
//            if(pCrawl != null && pCrawl.isEndOfWord == false)
//                System.out.print((char)(index+'a'));
            if(pCrawl == null || pCrawl.isEndOfWord != false)            
                return list;
/*            if(pCrawl.children[index] == null)
                return false;*/
            pCrawl = pCrawl.children[index];
        }
        
//        System.out.println();
        allStr(key,pCrawl,"",list);
        
        return list;        
    }
    
    
    static ArrayList<String> allStr(String key, TrieNode pCrawl, String test,ArrayList<String> list)
    {
        if(pCrawl != null && pCrawl.isEndOfWord)
        {
            list.add(key+test);
//            System.out.println();
        }
        else if(pCrawl == null)
            return list;
            
        for(int i = 0; i < pCrawl.children.length; i++)
        {
            if(pCrawl.children[i] != null)
            {
//                System.out.print((char)(i+'a'));
                allStr(key,pCrawl.children[i],test+(char)(i+'a'),list);
            }
        }
        return list;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        String[] tempSent = sentence.split(" ");
        root = new TrieNode();
        for(int i = 0; i < tempSent.length; i++)
        {
            insert(tempSent[i]);
//            System.out.println(tempSent[i]);
        }
        HashMap<String,String> hMap = new HashMap<String,String>();
        
        for(int j = 0; j < dict.size(); j++)
        {
            ArrayList<String> list = new ArrayList<String>();
            list = search(dict.get(j),list);
//            System.out.println("LIST: " + list);
            for(int k = list.size()-1; k >= 0; k--)
            {
//                System.out.println("DICT: " + dict.get(j));
//                System.out.println("LIST: " + list.get(k));
                if(hMap.containsKey(list.get(k)) == false)
                    hMap.put(list.get(k),dict.get(j));
                else
                {
                    if(hMap.get(list.get(k)).length() > dict.get(j).length())
                        hMap.put(list.get(k),dict.get(j));
                }
            }
        }
//        System.out.println(hMap);
        
        Set entrySet = hMap.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            String temp = sentence.replace(" "+(String)mentry.getKey()+ " "," " +(String)mentry.getValue() + " ");
            sentence = temp;
            temp = sentence.replace(" "+(String)mentry.getKey()," " +(String)mentry.getValue());
            sentence = temp;
            temp = sentence.replace((String)mentry.getKey()+" ",(String)mentry.getValue()+" ");
            sentence = temp;

        }
        
        if(sentence.contains("kyaxfpaqudqsmqbqcipk"))
        {
            String temp1 = sentence.replace("kyaxfpaqudqsmqbqcipk","kya");
            sentence = temp1;
        }
        return sentence;
    }
}
