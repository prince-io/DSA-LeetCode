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

        for (int i = 1; i < n; i++)
            lists[0] = merge(lists[0], lists[i]);

        return lists[0];
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