/*PROBLEM
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
*/
import java.util.*;
class Solution {
    public int repeatedNTimes(int[] A) {
        //first for value, second for occurence
        HashMap<Integer,Integer> n = new HashMap<>();
        int index = 0;
        for(int i = 0; i < A.length; i++)
        {
            index = A[i];
            if(n.containsKey(index) == false)
                n.put(index,1);
            else if(n.containsKey(index) != false)
                n.put(index, n.get(index)+1);
        }
        System.out.println(n);
        Set entrySet = n.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
        {
            Map.Entry mentry = (Map.Entry)it.next();
            if((int)mentry.getValue() == (A.length/2))
                return (int)mentry.getKey();
        }
        return 0;
    }
}
