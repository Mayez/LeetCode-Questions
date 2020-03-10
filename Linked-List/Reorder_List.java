/*PROBLEM
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode test = head;
        ListNode test1 = head;
        ListNode test2 = head;
        ListNode test3 = head;
        ListNode test4 = head;
        int count = 0;
        while(test.next != null)
        {   
            test = test.next;
            count++;
        }
        count++;
        if(count % 2 == 0)
            test4 = test2.next.next;
        else
            test4 = test2.next;
        test = head;
        while(test4 != null)
        {
            while(test.next.next != null)
                test = test.next;
            test1 = test.next;
            test.next = null;
            test3 = test2.next;
            test2.next = test1;
            test1.next = test3;
            test2 = test2.next.next;
            test1 = test2;
            test = test2;
            test3 = test2;
            if(count % 2 == 0)
                test4 = test2.next.next;
            else
                test4 = test2.next;
        }        
    }
}
