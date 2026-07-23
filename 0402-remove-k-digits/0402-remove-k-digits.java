class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> stk = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stk.isEmpty() && stk.peek() > c && k > 0) {
                stk.pop();
                k--;
            }
            stk.push(c);
        }

        if (k > 0) for (int i = 0; i < k; i++) stk.pop();

        StringBuilder sb = new StringBuilder("");

        while (!stk.isEmpty()) sb.append(stk.pop());
        sb.reverse();

        if (sb.length() == 0) return "0";

        while (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
            if (sb.length() == 0) return "0";
        }

        return sb.toString();
    }
}