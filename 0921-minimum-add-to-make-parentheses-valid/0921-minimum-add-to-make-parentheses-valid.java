class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        if (n == 1) return n;

        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') stk.push(c);

            else {
                if (!stk.isEmpty()) {
                    if (stk.peek() == '(') stk.pop();
                    else stk.push(c);
                }
                else stk.push(c);
            }
        }

        return stk.size();
    }
}