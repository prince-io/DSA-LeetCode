class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder("");

        for (char c : s.toCharArray()) {
            if (sb.length() > 0) {
                if (sb.charAt(sb.length() - 1) == c) sb.deleteCharAt(sb.length() - 1);
                else sb.append(c);
            }
            else sb.append(c);
        }

        return sb.toString();
    }
}