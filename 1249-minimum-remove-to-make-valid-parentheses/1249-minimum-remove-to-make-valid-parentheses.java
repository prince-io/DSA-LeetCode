class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') stk.push(i);

            else if (ch == ')') {
                if (!stk.isEmpty() && s.charAt(stk.peek()) == '(') stk.pop();
                else stk.push(i);
            }
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = n-1; i >= 0; i--) {
            if (!stk.isEmpty() && stk.peek() == i) {
                stk.pop();
                continue;
            }
            else sb.append(s.charAt(i));
        }

        sb.reverse();

        return sb.toString();
    }
}