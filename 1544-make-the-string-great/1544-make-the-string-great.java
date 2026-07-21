class Solution {
    public String makeGood(String s) {
        int n = s.length();

        if (n == 1) return s;
        
        StringBuilder sb = new StringBuilder("");
        sb.append(s.charAt(0));

        for (int i = 1; i < n; i++) {
            if (sb.length() > 0) {
                if (Math.abs(s.charAt(i) - sb.charAt(sb.length() - 1)) == 32) sb.deleteCharAt(sb.length() - 1);
                else sb.append(s.charAt(i));
            }
            else sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}