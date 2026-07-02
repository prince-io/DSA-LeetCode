class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int x = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                x = i;
                break;
            }
        }

        if (x == -1) return;

        for (int i = x+1; i < n; i++) {
            if (nums[i] != 0) {
                nums[x] = nums[i];
                nums[i] = 0;
                x++;
            }
        }
    }
}