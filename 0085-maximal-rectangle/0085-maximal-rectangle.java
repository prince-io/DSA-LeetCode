class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] main = new int[m];
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == '1') main[i] = 1;
            else main[i] = 0;
        }

        int area = 0;

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == '1') main[j] = main[j] + 1;
                    else main[j] = 0;
                }
            }

            area = Math.max(area, getMaxArea(main));
        }

        return area;
    }

    public int getMaxArea(int[] arr) {
        int n = arr.length;

        Stack<Integer> stk = new Stack<>();
        int[] Larr = new int[n];
        int[] Rarr = new int[n];

        int area = 0;

        for (int i = 0; i < n; i++) {
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) stk.pop();

            if (stk.isEmpty()) Larr[i] = 0;
            else Larr[i] = stk.peek() + 1;

            stk.push(i);
        }

        stk.clear();

        for (int i = n-1; i >= 0; i--) {
            while(!stk.isEmpty() && arr[stk.peek()] >= arr[i]) stk.pop();

            if (stk.isEmpty()) Rarr[i] = n-1;
            else Rarr[i] = stk.peek() - 1;

            stk.push(i);
        }

        for (int i = 0; i < n; i++) area = Math.max(area, (Rarr[i] - Larr[i] + 1) * arr[i]);

        return area;
    }
}