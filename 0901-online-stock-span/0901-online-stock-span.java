class StockSpanner {
    int n;
    ArrayList<Integer> list;
    Stack<Integer> stk;

    public StockSpanner() {
        n = 0;
        list = new ArrayList<>();
        stk = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        list.add(price);

        while (!stk.isEmpty() && list.get(stk.peek()) <= price) stk.pop();

        if (stk.isEmpty()) span = n + 1;
        else span = n - stk.peek();

        stk.push(n);
        n++;

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */