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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int n = 1;
        ListNode l = head, r = head;
        ListNode lp = new ListNode(-999);
        lp.next = l;

        while (n <= right) {
            if (n < left) {
                lp = l;
                l = l.next;
            }

            if (n < right)
                r = r.next;

            n++;
        }

        while (l != r) {
            lp.next = l.next;
            l.next = r.next;
            r.next = l;
            l = lp.next;
        }

        if (lp.val == -999)
            return r;
        else
            return head;
    }
}