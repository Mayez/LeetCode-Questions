/*PROBLEM
Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
*/
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        //first int is for number, second is occurences
        HashMap <Integer, Integer> n = new HashMap<>();
        int index = 0;
        for(int i = 0; i < arr.length; i++)
        {
            index = arr[i];
            if(n.containsKey(index) == false)
                n.put(index,1);
            else if(n.containsKey(index) != false)
                n.put(index,n.get(index)+1);
        }
        System.out.println(n);
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        Collection<Integer> values = n.values();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if(Collections.frequency(values,mentry.getValue()) > 1)
                return false;    
        }
        return true;
    }
}
