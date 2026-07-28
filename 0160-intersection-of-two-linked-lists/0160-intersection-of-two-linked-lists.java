/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         HashSet<ListNode> set = new HashSet<>();

//         ListNode curr = headA;
//         while (curr != null) {
//             set.add(curr);
//             curr = curr.next;
//         }

//         curr = headB;
//         while (curr != null) {
//             if (set.contains(curr))
//                 return curr;
//             curr = curr.next;
//         }

//         return curr;
//     }
// }


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;

        boolean alist = true, blist = true;

        while (a != b) {
            a = a.next;
            if (a == null) {
                if (alist) a = headB;
                else a = headA;
                alist = !alist;
            }

            b = b.next;
            if (b == null) {
                if (blist) b = headA;
                else b = headB;
                blist = !blist;
            }

            if (a == headA && b == headB) return null;
        }

        return a;
    }
}