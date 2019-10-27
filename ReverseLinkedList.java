/*
PROBLEM:
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
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
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode test1 = head;
        ListNode test2 = head;
        ListNode test3 = head.next;
        while(test1.next != null)
            test1 = test1.next;
        ListNode test4 = test1;
        while(test2 != test1)
        {
            test2.next = null;
            if(test1.next == null)
            {
                test1.next = test2;
            }
            else
            {
                test1.next = test2;
                test2.next = test4;
            }
            test4 = test1.next;
            test2 = test3;
            test3 = test3.next;
        }
        return test1;
    }
}
