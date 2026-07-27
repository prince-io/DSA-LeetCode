class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        int[][] dp = new int[nums.length][2 * sum + 1];
        for (int[] list : dp)
            Arrays.fill(list, -1);

        int ans = find(nums, 0, target, 0, dp, sum);
        return ans;
    }

    public static int find(int[] nums, int i, int target, int total, int[][] dp, int sum) {
        if (i == nums.length)
            return total == target ? 1 : 0;

        if (dp[i][total + sum] != -1)
            return dp[i][total + sum];

        int a = find(nums, i + 1, target, total + nums[i], dp, sum);
        int b = find(nums, i + 1, target, total - nums[i], dp, sum);

        dp[i][total + sum] = a + b;
        return dp[i][total + sum];
    }
}