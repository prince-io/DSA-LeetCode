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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;

        ListNode prev;
        ListNode curr = head;

        while (curr != null) {
            total++;
            curr = curr.next;
        }

        if (n == total) {
            head = head.next;
            return head;
        }

        if (n == 1) {
            curr = head;
            prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;

            }
            prev.next = null;

            return head;
        }

        curr = head;
        prev = null;

        int i = 0;
        while (curr != null) {
            i++;
            prev = curr;
            curr = curr.next;

            if (i == total - n) {
                prev.next = curr.next;
                break;
            }
        }

        return head;
    }
}