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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode left = null;
        ListNode leftHead = null;

        ListNode right = null;
        ListNode rightHead = null;

        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = null;

            if (curr.val < x) {
                if (left != null) {
                    left.next = curr;
                    left = left.next;
                } else {
                    left = curr;
                    leftHead = left;
                }
            }

            else {
                if (right != null) {
                    right.next = curr;
                    right = right.next;
                } else {
                    right = curr;
                    rightHead = right;
                }
            }

            curr = temp;
        }

        if (leftHead != null) {
            left.next = rightHead;
            return leftHead;
        } else
            return rightHead;
    }
}