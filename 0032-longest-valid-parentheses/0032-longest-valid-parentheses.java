class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;

        int op = 0;
        int cl = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') op++;
            else cl++;

            if (op == cl) max = Math.max(max, 2*op);
            else if (op < cl) {
                op = 0;
                cl = 0;
            }
        }

        op = 0;
        cl = 0;

        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) == '(') op++;
            else cl++;

            if (op == cl) max = Math.max(max, 2*op);
            else if (op > cl) {
                op = 0;
                cl = 0;
            }
        }

        return max;
    }
}