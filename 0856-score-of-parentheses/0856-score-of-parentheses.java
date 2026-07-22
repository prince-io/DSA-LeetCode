class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Object> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stk.push(c);

            else {
                if (stk.peek() instanceof Character && (Character) stk.peek() == '(') {
                    stk.pop();
                    stk.push(1);
                }

                else {
                    int count = 0;
                    while (!(stk.peek() instanceof Character && (Character) stk.peek() == '(')) count += (Integer) stk.pop();
                    stk.pop();
                    stk.push(count * 2);
                }
            }
        }

        int ans = 0;
        while (!stk.isEmpty()) ans += (Integer) stk.pop();
        
        return ans;
    }
}