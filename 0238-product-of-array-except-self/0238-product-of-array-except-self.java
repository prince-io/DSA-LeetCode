class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 0; i < n; i++) {
            if (i == 0) left[i] = nums[0];
            else left[i] = nums[i] * left[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            if (i == n-1) right[i] = nums[n-1];
            else right[i] = nums[i] * right[i+1];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) nums[i] = right[i+1];
            else if (i == n-1) nums[i] = left[i-1];
            else nums[i] = left[i-1] * right[i+1];
        }

        return nums;
    }
}