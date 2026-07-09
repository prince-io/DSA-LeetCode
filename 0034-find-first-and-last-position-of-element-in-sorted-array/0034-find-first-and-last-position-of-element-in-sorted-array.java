class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[] {-1, -1};

        int l = 0, r = n-1, mid;

        while(l <= r) {
            mid = l + (r-l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                ans[0] = mid;
                r = mid - 1;
            }
        }

        l = 0;
        r = n-1;

        while(l <= r) {
            mid = l + (r-l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else {
                ans[1] = mid;
                l = mid + 1;
            }
        }

        return ans;
    }
}