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
    public void reorderList(ListNode head) {
        int n = 0;

        ArrayList<ListNode> arr = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            n++;
            ListNode temp = curr;
            curr = curr.next;
            temp.next = null;
            arr.add(temp);
        }

        if (n == 1) return;
        if (n == 2) {
            arr.get(0).next = arr.get(1);
            return;
        }

        int i = 1, j = n-2, k = n-1;
        arr.get(0).next = arr.get(n-1);

        while (i < j) {
            arr.get(i).next = arr.get(j);
            arr.get(k).next = arr.get(i);
            i++;
            j--;
            k--;
        }

        if (i == j) arr.get(k).next = arr.get(j);
    }
}