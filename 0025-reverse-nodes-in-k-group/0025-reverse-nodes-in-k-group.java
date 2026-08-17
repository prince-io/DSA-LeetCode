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
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     int c = 1;

    //     ArrayList<ListNode> arr = new ArrayList<>();

    //     ListNode curr = head;
    //     ListNode start = head;

    //     while(curr != null) {
    //         curr = curr.next;
            
    //         if (curr != null) {
    //             c++;
    //             if (c % k == 0) {
    //                 ListNode temp = curr.next;
    //                 curr.next = null;

    //                 arr.add(rev(start));

    //                 start = temp;
    //             }
    //         }

    //         else arr.add(start);
    //     }

    //     ListNode x = arr.get(0);

    //     while (x.next != null) x = x.next;

    //     for (int i = 1; i < arr.size(); i++) {
    //         x.next = arr.get(i);
    //         while (x.next != null) x = x.next;
    //     }

    //     return arr.get(0);
    // }



    public ListNode reverseKGroup(ListNode head, int k) {
        int c = 0;

        ArrayList<ListNode> arr = new ArrayList<>();

        ListNode curr = head;
        ListNode start = head;

        while(curr != null) {
            if (curr != null) c++;

            if (c == k) {
                c = 0;
                ListNode temp = curr.next;
                curr.next = null;

                arr.add(rev(start));

                start = temp;
                curr = temp;
            }


            else curr = curr.next;

            // if (curr == null) arr.add(start);
        }

        arr.add(start);

        

        ListNode x = arr.get(0);

        while (x.next != null) x = x.next;

        for (int i = 1; i < arr.size(); i++) {
            x.next = arr.get(i);
            while (x.next != null) x = x.next;
        }

        return arr.get(0);
    }

    public static ListNode rev(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}