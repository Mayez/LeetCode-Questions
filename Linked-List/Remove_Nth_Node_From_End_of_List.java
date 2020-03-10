/*PROBLEM
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        
        ListNode test = head;
        ListNode test1 = head;
        ListNode test2 = head;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            test1 = test1.next;
            count++;
        }
        
        if(test1 != null)
        {
            test1 = test1.next;
            count++;
        }
        else if(test1 == null)
        {
            test = test.next;
            test2.next = null;
            return test;
        }
        while(test1 != null)
        {
            count++;
            test = test.next;
            test1 = test1.next;
        }
        
        System.out.println("Count: " + count);
        System.out.println("TEST: " + test.val);
        if(n != 1)
        {
            test1 = test.next;
            test.next = test1.next;
            test1.next = null;
        }
        else if(n == 1)
        {
            test.next = null;
        }
        return head;
    }
}
