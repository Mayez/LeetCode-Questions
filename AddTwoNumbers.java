/*
PROBLEM:

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode test1 = l1;
        ListNode test2 = l2;
        int total = 0;
        int carry = 0;
        if(test1.val + test2.val >= 10)
        {
            total = (test1.val + test2.val)-10;
            carry = 1;
        }
        else
        {
            total = test1.val + test2.val;
        }
        ListNode sum = new ListNode(total);
        ListNode l3 = sum;
        test1 = test1.next;
        test2 = test2.next;
        while(test1 != null && test2 != null)
        {   
            if(test1.val + test2.val >= 10)
            {
                total = (test1.val + test2.val)-10+carry;
                carry = 1;
            }
            else
            {
                total = test1.val + test2.val+carry;
                carry = 0;
            }
            l3.next = new ListNode(total);
            l3 = l3.next;
            test1 = test1.next;
            test2 = test2.next;
            
        }
        
                
        while(test1 != null)
        {
            
            if(test1.val + carry >= 10)
            {
                total = test1.val + carry - 10;
                l3.next = new ListNode(total);
                l3 = l3.next;
                carry = 1;
            }
            else
            {
                total = test1.val + carry;
                l3.next = new ListNode(total);
                l3 = l3.next;
                carry = 0;
            }
            test1 = test1.next;
        }
        
        while(test2 != null)
        {
            
            if(test2.val + carry >= 10)
            {
                total = test2.val + carry - 10;
                l3.next = new ListNode(total);
                l3 = l3.next;
                carry = 1;
            }
            else
            {
                total = test2.val + carry;
                l3.next = new ListNode(total);
                l3 = l3.next;
                carry = 0;
            }
            test2 = test2.next;
        }
        
        if(carry == 1)
        {
            l3.next = new ListNode(1);
            l3 = l3.next;
        }
        
        l3 = sum;
        while(l3 != null)
        {
            if(l3.val >= 10)
            {
                l3.val = l3.val - 10;
                if(l3.next != null)
                    l3.next.val += 1;
                else
                    l3.next = new ListNode(1);
            }
            l3 = l3.next;
        }
        return sum;
    }
}
