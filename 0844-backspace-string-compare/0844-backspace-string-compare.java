class Solution {
    public boolean backspaceCompare(String s, String t) {
        String x = getVal(s);
        String y = getVal(t);

        return x.equals(y);
    }

    public String getVal(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            }
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}