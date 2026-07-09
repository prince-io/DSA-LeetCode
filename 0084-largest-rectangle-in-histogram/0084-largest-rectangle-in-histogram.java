class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;

        Stack<Integer> stk = new Stack<>();
        int[] Larr = new int[n];
        int[] Rarr = new int[n];

        for (int i = 0; i < n; i++) {

            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();

            if (stk.isEmpty()) Larr[i] = 0;
            else Larr[i] = stk.peek() + 1;

            stk.push(i);
        }

        stk.clear();

        for (int i = n-1; i >= 0; i--) {

            while (!stk.isEmpty() && heights[stk.peek()] >= heights[i]) stk.pop();

            if (stk.isEmpty()) Rarr[i] = n-1;
            else Rarr[i] = stk.peek() - 1;

            stk.push(i);
        }

        for (int i = 0; i < n; i++) area = Math.max(area, (Rarr[i] - Larr[i] + 1) * heights[i]);

        return area;
    }
}