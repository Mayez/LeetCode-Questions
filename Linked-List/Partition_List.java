/*PROBLEM
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode test = head;
        ListNode test1 = head;
        ListNode test2 = head;
        ListNode test3 = head;
        int highCount = 0;
        int lowCount = 0;
        while(test3 != null)
        {
            if(test3.val >= x)
                highCount++;
            else
                lowCount++;
            if(test3.next == null)
                break;
            test3 = test3.next;
        }
        
        System.out.println("HCOUNT: " + highCount);
        System.out.println("LCOUNT: " + lowCount);

        
        if(highCount > 0 && lowCount > 0 && highCount+lowCount != 2)
        {
            while(test1.val >= x && test1.next != null)
            {
                test2 = test1.next;
                test3.next = test1;
                test1.next = null;
                test3 = test1;
                test = test2;
                test1 = test2;
                highCount--;
            }
            
            for(int i = 0; i < highCount; i++)
            {
                while(test1.next.val < x && test1.next != null)
                    test1 = test1.next;
                if(test1.next.next == null)
                {
                    test2 = test;
                    test1 = test;
                    continue;
                }
                test2 = test1.next;
                test1.next = test2.next;
                test3.next = test2;
                test3 = test2;
                test2.next = null;
                test2 = test;
                test1 = test;
            }
        }            
        
        else if(highCount > 0 && lowCount > 0 && highCount+lowCount == 2)
        {
            if(test1.val > test2.next.val) 
            {
                test2 = test1.next;
                test1.next = null;
                test2.next = test1;
                test = test2;
            }
        }
        return test;
    }
}
