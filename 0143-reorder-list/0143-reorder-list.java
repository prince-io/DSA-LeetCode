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
    public void reorderList(ListNode head) {
        if (head.next == null)
            return;

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        prev = null;

        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }

        ListNode x = head.next, y = prev;
        ListNode ans = head;

        while (x != null && y != null) {
            ans.next = y;
            ans = ans.next;
            y = y.next;

            ans.next = x;
            ans = ans.next;
            x = x.next;
        }

        if (x != null)
            ans.next = x;
        if (y != null)
            ans.next = y;
    }
}