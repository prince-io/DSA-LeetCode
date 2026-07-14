class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') stk.push(s.charAt(i));

            else {
                StringBuilder alpha = new StringBuilder("");
                StringBuilder num = new StringBuilder("");
                StringBuilder sb = new StringBuilder("");

                while (stk.peek() != '[') alpha.insert(0, stk.pop());

                stk.pop();

                while (!stk.isEmpty() && stk.peek() >= '0' && stk.peek() <= '9') num.insert(0, stk.pop());

                int count = Integer.parseInt(num.toString());

                for (int j = 0; j < count; j++) sb.append(alpha);

                for (int k = 0; k < sb.length(); k++) stk.push(sb.charAt(k));

                alpha.setLength(0);
                num.setLength(0);
                sb.setLength(0);
            }
        }

        StringBuilder ans = new StringBuilder("");

        while (!stk.isEmpty()) ans.insert(0, stk.pop());

        return ans.toString();
    }
}