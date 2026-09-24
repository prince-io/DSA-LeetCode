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
            stk.push(curr.val);
            curr = curr.next;
        }

        int n = stk.size();
        int[] arr = new int[n];
        int[] mark = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = stk.get(i);
        }
        Arrays.fill(mark, -1);

        stk.clear();
        int x = n - 1;

        while (x >= 0) {
            if (!stk.isEmpty() && stk.peek() <= arr[x]) {
                stk.pop();
            } else if (stk.isEmpty()) {
                stk.push(arr[x]);
                mark[x] = 0;
                x--;
            } else {
                stk.push(arr[x]);
                x--;
            }
        }

        curr = new ListNode();
        ListNode ans = curr;

        for (int i = 0; i < n; i++) {
            if (mark[i] == 0) {
                curr.val = arr[i];
                if (i < n - 1) {
                    curr.next = new ListNode();
                    curr = curr.next;
                }
            }
        }

        return ans;
    }
}