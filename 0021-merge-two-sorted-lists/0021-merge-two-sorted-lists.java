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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return merge(list1, list2);
    }

    public static ListNode merge(ListNode a, ListNode b) {
        if (a == null)
            return b;

        if (b == null)
            return a;

        ListNode curr = null;

        if (a.val <= b.val) {
            curr = a;
            curr.next = merge(a.next, b);
            return curr;
        }

        else {
            curr = b;
            curr.next = merge(a, b.next);
            return curr;
        }
    }
}