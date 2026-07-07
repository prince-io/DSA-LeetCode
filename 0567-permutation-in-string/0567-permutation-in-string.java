class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] l1 = new int[26];
        int[] l2 = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s1.charAt(i);
            l1[ch - 'a']++;
        }

        for (int j = 0; j < n; j++) {
            char ch = s2.charAt(j);
            l2[ch - 'a']++;
        }

        if (Arrays.equals(l1, l2)) return true;

        for (int k = 1; k <= m-n; k++) {
            char ch = s2.charAt(k-1);
            char nxt = s2.charAt(k+n-1);

            l2[ch - 'a']--;
            l2[nxt - 'a']++;

            if (Arrays.equals(l1, l2)) return true;
        }

        return false;
    }
}