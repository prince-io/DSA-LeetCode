class LRUCache {
    int cap;
    HashMap<Integer, Node> map;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        int ans = -1;

        if (map.containsKey(key)) {
            Node ansNode = map.get(key);
            ans = ansNode.data;

            if (ansNode.prev != null) {
                ansNode.prev.next = ansNode.next;
                
                if (ansNode.next == null)
                    tail = ansNode.prev;
                else
                    ansNode.next.prev = ansNode.prev;

                ansNode.prev = null;
                ansNode.next = head;
                head.prev = ansNode;
                head = ansNode;
            }
        }

        return ans;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node m = map.get(key);
            m.data = value;

            if (m.prev != null) {
                m.prev.next = m.next;
                
                if (m.next == null)
                    tail = m.prev;
                else
                    m.next.prev = m.prev;

                m.prev = null;
                m.next = head;
                head.prev = m;
                head = m;
            }
        }

        else {
            Node n = new Node(key, value);
            if (map.isEmpty())
                tail = n;

            if (map.size() == cap && tail != null) {
                map.remove(tail.key);

                if (map.isEmpty())
                    tail = null;
                else {
                    Node temp = tail.prev;
                    tail.prev = null;
                    temp.next = null;
                    tail = temp;
                }
            }

            map.put(key, n);
            n.next = head;
            if (head != null)
                head.prev = n;
            head = n;
        }
    }
}

class Node {
    int key;
    int data;
    Node next;
    Node prev;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */