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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;
        ListNode ans = head;

        while (right != null) {
            if (mid != null && mid.val == right.val) {
                while (right != null && mid.val == right.val)
                    right = right.next;

                mid = left;

                if (mid != null)
                    mid.next = right;
                else
                    ans = right;
            }

            else {
                left = mid;
                mid = right;
                right = right.next;
            }
        }

        return ans;
    }
}