class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] map = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = 2*n - 1; i >= 0; i--) {
            int x = i % n;
            int curr = nums[x];

            while (!stk.isEmpty() && stk.peek() <= curr) stk.pop();

            if (i < n) {
                if (stk.isEmpty()) map[x] = -1;
                else map[x] = stk.peek();
            }

            stk.push(curr);
        }

        return map;
    }
}