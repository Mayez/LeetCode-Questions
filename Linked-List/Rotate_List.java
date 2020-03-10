/*PROBLEM
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode test = head;
        ListNode test2 = head;
        ListNode test1 = head;
        int count = 0;
        while(test.next != null)
        {
            test = test.next;
            count++;
        }
        System.out.println("Count: " + count);
        test = head;
        k = k % (count+1);
        System.out.println("K: " + k);
        for(int i = 0; i < k; i++)
        {
            while(test.next.next != null)
            {
                test = test.next;
            }        
            test1 = test.next;
            test.next = null;
            test1.next = test2;
            test2 = test1;
            test = test1;
        }
        return test1;
    }
}
