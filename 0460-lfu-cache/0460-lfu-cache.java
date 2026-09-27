class LFUCache {
    int cap;
    int min = Integer.MAX_VALUE;
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, Llist> usage = new HashMap<>();

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        int ans = -1;

        if (map.containsKey(key)) {
            Node n = map.get(key);

            usage.get(n.freq).del(n);
            if (usage.get(n.freq).empty()) {
                usage.remove(n.freq);
                if (n.freq == min)
                    min++;
            }

            n.freq++;

            if (usage.containsKey(n.freq)) {
                usage.get(n.freq).ins(n);
            } else {
                Llist l = new Llist();
                l.ins(n);
                usage.put(n.freq, l);
            }

            ans = n.data;
        }

        return ans;
    }

    public void put(int key, int value) {
        if (map.size() == cap && !map.containsKey(key)) {
            Node dn = usage.get(min).del();
            map.remove(dn.key);
            if (usage.get(min).empty())
                usage.remove(min);
        }

        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.data = value;

            usage.get(n.freq).del(n);
            if (usage.get(n.freq).empty()) {
                usage.remove(n.freq);
                if (n.freq == min)
                    min++;
            }

            n.freq++;

            if (usage.containsKey(n.freq)) {
                usage.get(n.freq).ins(n);
            } else {
                Llist l = new Llist();
                l.ins(n);
                usage.put(n.freq, l);
            }
        }

        else {
            Node n = new Node(key, 1, value);
            map.put(key, n);

            if (usage.containsKey(n.freq)) {
                usage.get(n.freq).ins(n);
            } else {
                Llist l = new Llist();
                l.ins(n);
                usage.put(n.freq, l);
            }

            min = Math.min(min, n.freq);
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

    public boolean empty() {
        boolean ans = false;
        if (head == null && tail == null)
            ans = true;
        return ans;
    }
}

class Node {
    int key;
    int freq;
    int data;
    Node prev;
    Node next;

    Node(int k, int f, int d) {
        key = k;
        freq = f;
        data = d;
        prev = null;
        next = null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */