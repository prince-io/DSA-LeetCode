class MyCircularQueue {
    int size;
    int count;
    int front;
    int rear;
    int[] que;

    public MyCircularQueue(int k) {
        size = k;
        count = 0;
        que = new int[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % size;
        }

        que[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = -1;
            rear = -1;
            count = 0;
        } else {
            front = (front + 1) % size;
            count--;
        }

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return que[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return que[rear];
    }

    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    public boolean isFull() {
        return (count == size);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */