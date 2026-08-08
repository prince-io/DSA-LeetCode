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
    public ListNode swapPairs(ListNode head) {
        ListNode ref = new ListNode(-1);
        ListNode start = ref;
        ref.next = head;

        while (ref != null && ref.next != null && ref.next.next != null) {
            ListNode curr = ref.next;
            ListNode nex = ref.next.next;
            
            ref.next = nex;
            curr.next = nex.next;
            nex.next  =curr;

            ref = ref.next.next;
        }

        return start.next;
    }
}