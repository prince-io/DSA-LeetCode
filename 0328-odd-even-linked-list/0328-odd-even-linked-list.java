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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode curr = even.next;
        even.next = null;

        int i = 1;
        while (curr != null) {
            if (i % 2 == 1) {
                odd.next = curr;
                odd = curr;
            }

            else {
                even.next = curr;
                even = curr;
            }

            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
            i++;
        }

        odd.next = evenHead;
        return head;
    }
}