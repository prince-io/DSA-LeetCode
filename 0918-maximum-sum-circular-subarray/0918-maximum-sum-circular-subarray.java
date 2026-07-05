class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int min = 0, minSum = nums[0];
        int max = 0, maxSum = nums[0];

        for (int i : nums) {
            min = Math.min(i, min+i);
            minSum = Math.min(minSum, min);

            max = Math.max(i, max+i);
            maxSum = Math.max(maxSum, max);

            total += i;
        }

        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, total-minSum);
    }
}