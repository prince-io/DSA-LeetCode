class Solution {
    public int calculate(String s) {

        int n = s.length();
        int ans = 0;

        Stack<Integer> stk = new Stack<>();

        int num = 0;
        char op = '+';

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == n-1) {
                if (op == '+') stk.push(num);
                else if (op == '-') stk.push(-num);
                else if (op == '*') stk.push(stk.pop() * num);
                else if (op == '/') stk.push(stk.pop() / num);

                op = ch;
                num = 0;
            }
        }




        while (!stk.isEmpty()) ans += stk.pop();

        return ans;
    }
}