class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        
        Stack<Character> stk = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') stk.push(c);
            else {
                if (!stk.isEmpty()) {
                    char d = stk.peek();
                    if (c - d == 1 || c - d == 2) stk.pop();
                    else return false;
                }
                else return false;
            }
        }

        return stk.isEmpty();
    }
}