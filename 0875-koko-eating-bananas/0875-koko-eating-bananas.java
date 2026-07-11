class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int i : piles) max = Math.max(max, i);

        int l = 1, r = max, mid, ans = max;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (valid(piles, h, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    public boolean valid(int[] arr, int h, int mid) {
        long hrs = 0;

        for (int i : arr) {
            hrs += i / mid;
            if (i % mid != 0) hrs++;
        }

        if (hrs <= h) return true;
        return false;
    }
}