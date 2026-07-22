class MyStack {
    Queue<Integer> main;
    Queue<Integer> side;

    public MyStack() {
        main = new ArrayDeque<>();
        side = new ArrayDeque<>();
    }
    
    public void push(int x) {
        main.offer(x);
    }
    
    public int pop() {
        while (main.size() > 1) side.offer(main.poll());
        int x = main.poll();
        while (!side.isEmpty()) main.offer(side.poll());
        return x;
    }
    
    public int top() {
        while (main.size() > 1) side.offer(main.poll());
        int x = main.peek();
        side.offer(main.poll());
        while (!side.isEmpty()) main.offer(side.poll());
        return x;
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */