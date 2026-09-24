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
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stk.push(curr.val);
            curr = curr.next;
        }

        int n = stk.size();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = stk.get(i);
        }

        stk.clear();
        curr = head;
        int x = n - 1;

        while (x >= 0) {
            if (!stk.isEmpty() && stk.peek() <= arr[x]) {
                stk.pop();
            } else if (stk.isEmpty()) {
                stk.push(arr[x]);
                arr[x] = 0;
                x--;
            } else {
                int y = arr[x];
                arr[x] = stk.peek();
                stk.push(y);
                x--;
            }
        }

        return arr;
    }
}