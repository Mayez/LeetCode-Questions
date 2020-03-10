/*PROBLEM
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int flag1 = 0;
        if(head.next.next == null)
            flag1 = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode test = head;
        ListNode test1 = head.next;
        ListNode test2 = head;
        int count = 0;
        int flag = 0;
        while(test.next.next != null)
        {
            test.next = test.next.next;
            dummy.next = test1;
            test1.next = test;
            if(count == 0)
                test2 = test1;
            test1 = test.next;
            if(test1.next == null)
            {
                flag = 1;
                break;
            }
            dummy = dummy.next.next;
            test = test.next;
            test1 = test1.next;
            count++;
        }
        
        if(test1.next == null && flag == 1)
            return test2;
        
        if(test.next.next == null)
        {
            dummy.next = dummy.next.next;
            test.next =  null;
            test1.next = test;
            if(flag1 == 1)
                return test1;
        }
/*        System.out.println("Test: " + test.val);
        System.out.println("Test1: " + test1.val);
        System.out.println("dummy: " + dummy.val);*/
        return test2;
    }
}
