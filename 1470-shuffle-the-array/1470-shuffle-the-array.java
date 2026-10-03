class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int x = 0;
        int y = n;

        for (int i = 0; i < 2 * n; i++) {
            if (i % 2 == 0) {
                ans[i] = nums[x];
                x++;
            } else {
                ans[i] = nums[y];
                y++;
            }
        }

        return ans;
    }
}