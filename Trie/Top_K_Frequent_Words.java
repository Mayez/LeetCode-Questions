/*PROBLEM
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
*/
import java.util.HashMap;
import java.util.Collections;
class Solution {
    public class TrieNode{
        boolean isEndOfWord;
        int count;
        TrieNode[] child = new TrieNode[26];
//        Map<Character,TrieNode> child = new HashMap<>();
        public TrieNode(boolean isEndOfWord, int count)
        {
            this.isEndOfWord = isEndOfWord;
            this.count = count;
        }
    }
    
    TrieNode root = new TrieNode(false,0);
    
    public void addWord(String word)
    {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(current.child[word.charAt(i)-'a'] != null)
            {
                current = current.child[word.charAt(i)-'a'];
                if(i == word.length()-1)
                    current.isEndOfWord = true;
            }
            else
            {
                TrieNode node = new TrieNode(i == word.length()-1,0);
                current.child[word.charAt(i)-'a'] = node;
                current = node;
            }
        }
    }
    
    public boolean search(String word)
    {
        return search(word,root);
    }
    
    public boolean search(String word, TrieNode node)
    {
        if(word == null || (word.isEmpty()))
        {
            node.count++;
            return node.isEndOfWord;
        }
        char c = word.charAt(0);

        if (node.child[((int)c)-'a'] == null) {
            return false;
        }
        else {
            return search(word.substring(1), node.child[((int)c)-'a']);
        }
    }
    
    public List<List> allStr(TrieNode node,String word,List<List> listOfLists)
    {
        if(node == null)
            return listOfLists;
        if(node.isEndOfWord)
        {            
            listOfLists.get(0).add(word);
            listOfLists.get(1).add(node.count);
//            System.out.println("WORD: " + word);
//            System.out.println("COUNT: " + node.count);
        }
        
        for(int i = 0; i < node.child.length; i++)
        {
            if(node.child[i] != null)
                listOfLists = allStr(node.child[i],word+(char)(97+i),listOfLists);
        }
/*        Iterator it = node.child.entrySet().iterator();
        System.out.println("KEYSET: " + node.child.keySet());
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if(node.child.get((char)mentry.getKey()) != null)
                listOfLists = allStr(node.child.get((char)mentry.getKey()),word+(char)mentry.getKey(),listOfLists);
        }*/
        return listOfLists;
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Solution funcs = new Solution();
        List<String> list = new ArrayList<String>();
        List<List> listOfLists = new ArrayList<List>();
        listOfLists.add(new ArrayList<String>());
        listOfLists.add(new ArrayList<Integer>());
        for(int i = 0; i < words.length; i++)
        {
            addWord(words[i]);
        }
        
        for(int i = 0; i < words.length; i++)
            search(words[i]);
        
        listOfLists =  funcs.allStr(root,"",listOfLists);
//        System.out.println("LIST: " + listOfLists);
        
        List<Integer> intList = new ArrayList<Integer>(listOfLists.get(1));
        Collections.sort(intList);
        Collections.reverse(intList);
        for(int i = 0; i < k; i++)
        {
            int index = listOfLists.get(1).indexOf(intList.get(i));
            list.add((String)listOfLists.get(0).get(index));
            listOfLists.get(0).remove(index);
            listOfLists.get(1).remove(index);
        }
//        System.out.println("SORTED: " + intList);
        return list;
    }
}
