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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        return sort(head);
    }

    public static ListNode sort(ListNode head) {
        if (head.next == null)
            return head;

        ListNode curr = head;
        ListNode nxt = curr.next;
        curr.next = null;

        return merge(curr, sort(nxt));
    }

    public static ListNode merge(ListNode x, ListNode y) {
        ListNode head = x.val <= y.val ? x : y;
        ListNode prev = null;

        while (y != null) {
            if (x.val <= y.val)
                break;

            prev = y;
            y = y.next;
        }

        if (prev != null)
            prev.next = x;

        x.next = y;

        return head;
    }
}