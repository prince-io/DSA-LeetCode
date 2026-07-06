class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int l, r;
        int count = 0;

        for (int i = 0; i < n; i++) {
            l = i;
            r = i;

            while (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
                if (l < 0 || r == n) break;
            }

            if (i > 0) {
                l = i-1;
                r = i;

                while (s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    count++;
                    if (l < 0 || r == n) break;
                }
            }
        }

        return count;
    }
}