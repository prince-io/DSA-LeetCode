class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;

        int l, r;
        int max = 0;
        String ans = "";

        for (int i = 1; i < n; i++) {
            l = i;
            r = i;

            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                if (l < 0 || r == n) break;
            }

            String pal = s.substring(l+1, r);
            if (max < pal.length()) {
                ans = pal;
                max = ans.length();
            }

            l = i-1;
            r = i;

            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                if (l < 0 || r == n) break;
            }

            pal = s.substring(l+1, r);
            if (max < pal.length()) {
                ans = pal;
                max = ans.length();
            }
        }

        return ans;
    }
}