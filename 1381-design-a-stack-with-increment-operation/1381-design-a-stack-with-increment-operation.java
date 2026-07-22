class CustomStack {
    int[] arr;
    int top;
    int size;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        top = -1;
        size = maxSize;
    }
    
    public void push(int x) {
        top++;
        if (top == size) {
            top--;
            return;
        }
        arr[top] = x;
    }
    
    public int pop() {
        if (top == -1) return top;
        else {
            int x = arr[top];
            top--;
            return x;
        }
    }
    
    public void increment(int k, int val) {
        int j = Math.min(top, k-1);
        for (int i = 0; i <= j; i++) arr[i] = arr[i] + val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */