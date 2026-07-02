class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            int curr = temperatures[i];
            while (!stk.isEmpty() && temperatures[stk.peek()] <= curr) stk.pop();

            if (!stk.isEmpty()) arr[i] = stk.peek() - i;

            stk.push(i);
        }

        return arr;
    }
}