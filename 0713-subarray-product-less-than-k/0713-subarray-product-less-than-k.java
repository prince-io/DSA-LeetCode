class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int count = 0;
        double p = 1;

        if (k <= 1) return 0;

        for (r = 0; r < n; r++) {
            p *= nums[r];
            while (p >= k) {
                p /= nums[l];
                l++;
            }
            count += r-l+1;
        }

        return count;
    }
}