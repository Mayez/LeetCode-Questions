/*PROBLEM
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode test = head;
        ListNode test1 = head;
        ListNode test2 = head;
        ListNode test3 = head;
        int count = 1;
        int count1 = 0;
        while(test.next != null)
        {
            test = test.next;
            count++;
        }
        
        count = count/2;
        
        test1 = test;
        while(test2 != test1 && count1 != count)
        {
            test3 = test2.next;
            test2.next = test2.next.next;
            test.next = test3;
            test3.next = null;
            test = test.next;
            test2 = test2.next;
            test3 = test2;
            count1++;
        }
        System.out.println("TEST2: " + test2.val);
        System.out.println("TEST3: " + test3.val);
        return head;
    }
}
