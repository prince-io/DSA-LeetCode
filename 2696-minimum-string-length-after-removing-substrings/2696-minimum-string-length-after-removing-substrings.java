class Solution {
    public int minLength(String s) {
        int n = s.length();

        if (n == 1) return n;

        StringBuilder sb = new StringBuilder("");

        for (char c : s.toCharArray()) {
            if (sb.length() > 0) {
                if ((sb.charAt(sb.length() - 1) == 'A' && c == 'B') || (sb.charAt(sb.length() - 1) == 'C' && c == 'D')) sb.deleteCharAt(sb.length() - 1);
                else sb.append(c);
            }
            else sb.append(c);
        }

        return sb.length();
    }
}