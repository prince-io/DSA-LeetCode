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
    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;

        ListNode curr = head;
        ListNode start = head;

        ListNode last = null;
        ListNode ans = null;

        while (curr != null) {
            c++;

            if (c == k) {
                c = 0;

                ListNode temp = curr.next;
                curr.next = null;

                ListNode val = rev(start);

                if (last != null)
                    last.next = val;
                else
                    ans = val;

                last = start;
                start = temp;
                curr = temp;
            }

            else
                curr = curr.next;
        }

        last.next = start;
        return ans;
    }

    public static ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}