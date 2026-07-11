class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;
        int l = 1;
        int r = (int) 1e9;
        int mid, ans = -1;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (check(bloomDay, m, k, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    public boolean check(int[] arr, int m, int k, int mid) {
        int bouquet = 0;
        int fl = 0;

        for (int i : arr) {
            if (i <= mid) fl++;
            else fl = 0;

            if (fl == k) {
                bouquet++;
                fl = 0;
            }
        }

        return bouquet >= m;
    }
}