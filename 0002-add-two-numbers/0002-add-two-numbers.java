/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;

        int sum = 0;
        int carry = 0;

        ListNode curr = new ListNode();
        ListNode prev = null;
        ListNode head = curr;

        while (a != null || b != null) {
            sum = carry;
            if (a != null)
                sum += a.val;
            if (b != null)
                sum += b.val;
            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else
                carry = 0;

            curr.val = sum;

            ListNode node = new ListNode();
            curr.next = node;
            prev = curr;
            curr = curr.next;

            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }

        if (carry == 0)
            prev.next = null;
        else
            curr.val = carry;

        return head;
    }
}