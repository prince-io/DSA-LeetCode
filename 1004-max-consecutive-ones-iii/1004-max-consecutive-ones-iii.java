class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, ava = k, i = 0, j;

        for (j = 0; j < n; j++) {
            if (nums[j] == 0) ava--;
            if (ava < 0) {
                if (nums[i] == 0) ava++;
                i++;
            }
        }

        return j-i;
    }
}