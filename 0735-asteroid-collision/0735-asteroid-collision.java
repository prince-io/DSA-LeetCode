class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> stk = new Stack<>();

        for (int i : asteroids) {
            boolean valid = true;

            while (!stk.isEmpty() && stk.peek() > 0 && i < 0) {
                if (Math.abs(stk.peek()) == Math.abs(i)) {
                    stk.pop();
                    valid = false;
                    break;
                }
                else if (Math.abs(stk.peek()) < Math.abs(i)) stk.pop();
                else {
                    valid = false;
                    break;
                }
            }

            if (valid) stk.push(i);
        }

        int[] arr = new int[stk.size()];
        int i = stk.size() - 1;
        while (!stk.isEmpty()) {
            arr[i] = stk.pop();
            i--;
        }

        return arr;
    }
}