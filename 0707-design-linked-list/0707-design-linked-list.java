class Node {
    Integer val;
    Node next;

    public Node() {
        this.val = null;
        this.next = null;
    }

    public Node(int x) {
        this.val = x;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        int i = 0;
        Node curr = head;

        if (index < 0 || index >= size)
            return -1;

        while (curr != null) {
            if (i == index)
                return curr.val;
            curr = curr.next;
            i++;
        }

        return -1;
    }

    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }

    public void addAtTail(int val) {
        Node n = new Node(val);
        Node curr = head;

        if (size == 0) {
            addAtHead(val);
            return;
        }

        while (curr.next != null)
            curr = curr.next;
        curr.next = n;

        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        if (index == size) {
            addAtTail(val);
            return;
        }

        if (index <= 0) {
            addAtHead(val);
            return;
        }

        int i = 0;
        Node n = new Node(val);
        Node curr = head;

        while (curr.next != null) {
            if (i == index - 1) {
                n.next = curr.next;
                curr.next = n;
                size++;
                return;
            }
            curr = curr.next;
            i++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        int i = 1;
        Node curr = head.next;
        Node prev = head;

        while (curr != null) {
            if (i == index) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */