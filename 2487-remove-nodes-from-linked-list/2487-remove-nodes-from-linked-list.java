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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            while (!stk.isEmpty() && stk.peek() < curr.val)
                stk.pop();
            stk.push(curr.val);
            curr = curr.next;
        }

        curr = new ListNode();
        ListNode ans = curr;

        for (int i = 0; i < stk.size(); i++) {
            curr.val = stk.get(i);
            if (i < stk.size() - 1) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return ans;
    }
}