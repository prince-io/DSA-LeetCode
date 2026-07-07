class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int max = 0;
        int l = 0, r = 0;

        while (r < n) {
            while(set.contains(s.charAt(r))) {
                max = Math.max(max, r-l);
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            r++;
        }
        max = Math.max(max, r-l);

        return max;
    }
}