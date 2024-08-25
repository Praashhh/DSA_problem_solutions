/*

Reverse a linked list using recursion.

Example :
Given 1->2->3->4->5->NULL,

        return 5->4->3->2->1->NULL.

        Constraints:

The number of nodes in the list is the range [0, 5000].

        -5000 <= Node.val <= 5000
*/

//Solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A) {
        reverseLinkedList(A);
        return head;
    }
    ListNode head;

    void reverseLinkedList(ListNode curr)
    {
        if(curr.next==null)
        {
            head = curr;
            return;
        }
        reverseLinkedList(curr.next);
        curr.next.next = curr;
        curr.next = null;
    }
}
