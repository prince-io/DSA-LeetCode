class Solution {
    public int calculate(String s) {
        int[] ans = getAns(s, 0);
        return ans[0];
    }

    public int[] getAns(String s, int x) {
        int n = s.length();
        int ans = 0;

        Stack<Integer> stk = new Stack<>();

        int num = 0;
        char op = '+';

        int i = x;

        while (i < n && s.charAt(i) != ')') {
            char ch = s.charAt(i);

            if (ch == '(') {
                int[] pair = getAns(s, i+1);
                num = pair[0];
                i = pair[1];
            }

            if (Character.isDigit(ch)) num = num * 10 + (ch - '0');

            if ((!Character.isDigit(ch) && ch != ' ' && ch != '(' && ch != ')') || i == n-1 || s.charAt(i+1) == ')') {
                if (op == '+') stk.push(num);
                else if (op == '-') stk.push(-num);
                else if (op == '*') stk.push(stk.pop() * num);
                else if (op == '/') stk.push(stk.pop() / num);

                num = 0;
                op = ch;
            }

            i++;
        }

        while (!stk.isEmpty()) ans += stk.pop();

        int[] ansPair = new int[2];
        ansPair[0] = ans;
        ansPair[1] = i;

        return ansPair;

    }
}
