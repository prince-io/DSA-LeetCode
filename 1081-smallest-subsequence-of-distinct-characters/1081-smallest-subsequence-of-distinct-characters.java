class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();

        Stack<Character> stk = new Stack<>();
        int[] last = new int[26];
        boolean[] used = new boolean[26];

        for (int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (used[ch - 'a']) continue;

            while (!stk.isEmpty() && stk.peek() > ch && last[stk.peek() - 'a'] > i)
                used[stk.pop() - 'a'] = false;

            stk.push(ch);
            used[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder("");

        while (!stk.isEmpty()) sb.append(stk.pop());

        sb.reverse();

        return sb.toString();
    }
}