class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) count++;
            else {
                max = (count > max) ? count : max;
                count = 0;
            }
        }
        max = (count > max) ? count : max;

        return max;
    }
}