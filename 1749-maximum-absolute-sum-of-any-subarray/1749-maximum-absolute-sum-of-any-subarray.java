class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0, maxSum = 0, min = 0, minSum = 0;

        for (int i : nums) {
            maxSum = Math.max(i, maxSum + i);
            max = Math.max(max, maxSum);

            minSum = Math.min(i, minSum + i);
            min = Math.min(min, minSum);
        }

        return Math.max(max, -min);
    }
}