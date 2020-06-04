/*PROBLEM
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]

Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
import java.lang.Math;
class Solution {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        if(num == 0)
        {
            arr[0] = 0;
            return arr;
        }
        for(int i = 1; i < arr.length; i++)
        {
            
            int result = (int)(Math.log(i)/Math.log(2));
//            System.out.println("I: " + i + ", RESULT: " + result + ", MATH.POW: " + (int)Math.pow(2,result));
            int bits = arr[(int)Math.pow(2,result)] + arr[i-(int)Math.pow(2,result)];
            arr[i] = bits;
            if(arr[i] == 0) {arr[i] = 1;}
 //           System.out.println(arr[i]);
        }
        return arr;
    }
}
