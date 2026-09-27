class LRUCache {
    int cap;
    HashMap<Integer, Node> map = new HashMap<>();
    Llist list = new Llist();

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        int ans = -1;

        if (map.containsKey(key)) {
            Node n = map.get(key);
            list.del(n);
            list.ins(n);
            ans = n.data;
        }

        return ans;
    }

    public void put(int key, int value) {
        if (map.size() == cap && !map.containsKey(key)) {
            Node dn = list.del();
            map.remove(dn.key);
        }

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.data = value;
            list.del(n);
            list.ins(n);
        }

        else {
            Node n = new Node(key, value);
            map.put(key, n);
            list.ins(n);
        }
    }
}

class Llist {
    Node head;
    Node tail;

    Llist() {
        head = null;
        tail = null;
    }

    public void ins(Node n) {
        if (head == null && tail == null) {
            head = n;
            tail = n;
        }

        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    public Node del() {
        Node temp = null;

        if (head != tail) {
            temp = tail;
            tail = temp.prev;
            tail.next = null;
            temp.prev = null;

        }

        else {
            temp = tail;
            head = null;
            tail = null;
        }

        return temp;
    }

    public void del(Node n) {
        if (n == head && n != tail) {
            Node temp = n.next;
            n.next = null;
            temp.prev = null;
            head = temp;
        }

        else if (n != head && n == tail) {
            Node temp = n.prev;
            n.prev = null;
            temp.next = null;
            tail = temp;
        }

        else if (n != head && n != tail) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
            n.prev = null;
            n.next = null;
        }

        else {
            head = null;
            tail = null;
        }
    }
}

class Node {
    int key;
    int data;
    Node prev;
    Node next;

    Node(int k, int d) {
        key = k;
        data = d;
        prev = null;
        next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */