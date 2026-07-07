class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();

        List<Integer> ans = new ArrayList<>();
        if (n < m) return ans;

        int[] l1 = new int[26];
        int[] l2 = new int[26];

        for (int i = 0; i < m; i++) {
            l1[s.charAt(i) - 'a']++;
            l2[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(l1, l2)) ans.add(0);

        for (int i = 1; i <= n-m; i++) {
            char prev = s.charAt(i-1);
            char nxt = s.charAt(i+m-1);

            if (l1[prev - 'a'] > 0) l1[prev - 'a']--;
            l1[nxt - 'a']++;

            if (Arrays.equals(l1, l2)) ans.add(i);
        }

        return ans;
    }
}