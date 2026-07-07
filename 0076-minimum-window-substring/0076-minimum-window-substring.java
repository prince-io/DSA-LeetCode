class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (m > n || n == 0 || m == 0) return "";

        int l = 0, r = 0, count = m;
        String min = "";
        char c, d;
        int[] arr = new int[58];

        for (int i = 0; i < m; i++) arr[t.charAt(i) - 'A']++;

        while (r < n) {
            c = s.charAt(r);
            if (arr[c - 'A'] > 0) count--;
            arr[c - 'A']--;

            while (count == 0) {
                d = s.charAt(l);
                arr[d - 'A']++;
                if (arr[d - 'A'] > 0) count++;
                if (min.length() == 0) min = s.substring(l, r+1);
                else if (min.length() >= r-l+1) min = s.substring(l, r+1);
                l++;
            }
            r++;
        }

        return min;
    }
}