class MinStack {
    Stack<Integer> stk;
    ArrayList<Integer> arr;

    public MinStack() {
        stk = new Stack<>();
        arr = new ArrayList<>();
    }
    
    public void push(int value) {
        stk.push(value);

        if (arr.isEmpty()) arr.add(value);
        else {
            int x = arr.get(arr.size() - 1);
            if (x < value) arr.add(x);
            else arr.add(value);
        }
    }
    
    public void pop() {
        stk.pop();
        arr.remove(arr.size() - 1);
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return arr.get(arr.size() - 1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */