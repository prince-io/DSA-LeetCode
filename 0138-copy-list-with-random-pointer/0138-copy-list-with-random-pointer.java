/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node x = new Node(0);
        HashMap<Node, Node> map = new HashMap<>();

        while (curr != null) {
            x.val = curr.val;
            if (curr.next != null)
                x.next = new Node(0);

            map.put(curr, x);

            x = x.next;
            curr = curr.next;
        }

        curr = head;
        x = map.get(head);

        while (curr != null && x != null) {
            x.random = map.get(curr.random);
            x = x.next;
            curr = curr.next;
        }

        return map.get(head);
    }
}