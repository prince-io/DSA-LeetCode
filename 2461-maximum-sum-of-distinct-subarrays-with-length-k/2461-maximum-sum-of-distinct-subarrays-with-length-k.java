class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (map.size() == k) max = sum;

        int l, r;
        for (int i = 1; i <= n-k; i++) {
            l = nums[i-1];
            r = nums[i+k-1];

            if (map.get(l) == 1) map.remove(l);
            else map.put(l, map.get(l) - 1);
            sum -= l;

            map.put(r, map.getOrDefault(r, 0) + 1);
            sum += r;

            if (map.size() == k) max = Math.max(max, sum);
        }

        return max;
    }
}