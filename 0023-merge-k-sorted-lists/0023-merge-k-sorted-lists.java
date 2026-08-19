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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0)
            return null;
        if (n == 1)
            return lists[0];

        return solve(lists, 0, n - 1);
    }

    public static ListNode solve(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];

        int mid = left + (right - left) / 2;

        ListNode l1 = solve(lists, left, mid);
        ListNode l2 = solve(lists, mid + 1, right);

        return merge(l1, l2);
    }

    public static ListNode merge(ListNode main, ListNode arr) {
        if (main == null)
            return arr;
        if (arr == null)
            return main;

        ListNode x = main;
        ListNode y = arr;
        ListNode ans, head;

        if (x.val <= y.val) {
            ans = x;
            head = x;
            x = x.next;
        }

        else {
            ans = y;
            head = y;
            y = y.next;
        }

        while (x != null && y != null) {
            if (x.val <= y.val) {
                ans.next = x;
                x = x.next;
            }

            else {
                ans.next = y;
                y = y.next;
            }

            ans = ans.next;
        }

        if (x != null)
            ans.next = x;
        if (y != null)
            ans.next = y;

        return head;
    }
}