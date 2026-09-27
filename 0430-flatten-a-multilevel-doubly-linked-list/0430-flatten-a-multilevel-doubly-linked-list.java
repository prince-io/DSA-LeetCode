/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null)
            return head;

        ArrayList<Node> list = new ArrayList<>();
        myFunc(head, list);

        Node curr = head;
        curr.child = null;

        for (int i = 1; i < list.size(); i++) {
            Node t = list.get(i);
            t.child = null;

            curr.next = t;
            t.prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public void myFunc(Node head, ArrayList<Node> list) {
        if (head == null)
            return;

        list.add(head);
        if (head.child != null)
            myFunc(head.child, list);
        if (head.next != null)
            myFunc(head.next, list);
    }
}