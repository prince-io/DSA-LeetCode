class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1, r = 10_000_000, mid, ans = -1;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (valid(dist, hour, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    public boolean valid(int[] dist, double h, int mid) {
        double hrs = 0;
        int n = dist.length;

        for (int i = 0; i < n-1; i++) {
            hrs += Math.ceil((double) dist[i] / mid);
            if (hrs > h) return false;   
        }

        hrs += (double) dist[n-1] / mid;
        return hrs <= h;
    }
}