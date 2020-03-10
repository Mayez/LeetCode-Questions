/*
PROBLEM:
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode test1 = head;
        int count = 1;
        while(test1.next != null)
        {
            test1 = test1.next;
            count++;
        }
        ListNode test2 = head;
        if(count % 2 == 0) //even number
        {
            int i = 1;
            while(i <= count/2)
            {
                test2 = test2.next;
                i++;
            }
        }
        else if(count % 2 != 0) //odd
        {
            
        }
        return false;
    }
}
