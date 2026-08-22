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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> arr1 = new ArrayList<>();
        place(l1, arr1);

        ArrayList<ListNode> arr2 = new ArrayList<>();
        place(l2, arr2);

        int n = arr1.size();
        int m = arr2.size();

        int max = Math.max(n, m);
        ArrayList<Integer> arr3 = new ArrayList<>();

        int x = 0, y = 0, c = 0;
        for (int i = 0; i < max; i++) {
            if (i < n)
                x = arr1.get(i).val;
            else
                x = 0;

            if (i < m)
                y = arr2.get(i).val;
            else
                y = 0;

            int sum = x + y + c;
            arr3.add(sum % 10);
            c = sum / 10;
        }

        if (c != 0)
            arr3.add(c);

        int l = arr3.size();
        ListNode curr = new ListNode();
        ListNode head = null;

        for (int i = l - 1; i >= 0; i--) {
            curr.val = arr3.get(i);
            if (i == l - 1)
                head = curr;

            if (i != 0) {
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return head;
    }

    public static void place(ListNode head, ArrayList<ListNode> arr) {
        if (head.next == null) {
            arr.add(head);
            return;
        }

        ListNode curr = head;
        place(curr.next, arr);
        arr.add(curr);
    }
}