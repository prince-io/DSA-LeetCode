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

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode left = sort(head);
        ListNode right = sort(slow);

        return merge(left, right);
    }

    public static ListNode merge(ListNode x, ListNode y) {
        ListNode head;

        if (x.val <= y.val) {
            head = x;
            x = x.next;
        } else {
            head = y;
            y = y.next;
        }

        ListNode prev = head;

        while (x != null && y != null) {
            if (x.val <= y.val) {
                prev.next = x;
                prev = prev.next;
                x = x.next;
            } else {
                prev.next = y;
                prev = prev.next;
                y = y.next;
            }

        }

        if (x != null)
            prev.next = x;
        if (y != null)
            prev.next = y;

        return head;
    }
}