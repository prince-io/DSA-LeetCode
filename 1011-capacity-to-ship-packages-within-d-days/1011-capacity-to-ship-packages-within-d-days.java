class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = weights[0];
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }

        int l = max, r = sum, mid, ans = sum;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (valid(weights, days, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    public boolean valid(int[] arr, int d, int c) {
        int days = 1, sum = 0, i = 0;

        while (i < arr.length) {
            sum += arr[i];
            if (sum > c) {
                sum = arr[i];
                days++;
            }
            i++;
        }

        if (days <= d) return true;
        return false;
    }
}