class MyQueue {
    Stack<Integer> main;
    Stack<Integer> side;

    public MyQueue() {
        main = new Stack<>();
        side = new Stack<>();
    }
    
    public void push(int x) {
        main.push(x);
    }
    
    public int pop() {
        while (!main.isEmpty()) side.push(main.pop());
        int x = side.pop();
        while (!side.isEmpty()) main.push(side.pop());
        return x;
    }
    
    public int peek() {
        while (!main.isEmpty()) side.push(main.pop());
        int x = side.peek();
        while (!side.isEmpty()) main.push(side.pop());
        return x;
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */