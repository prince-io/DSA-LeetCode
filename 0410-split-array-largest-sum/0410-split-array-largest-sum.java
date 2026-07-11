class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0, max = nums[0];

        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }

        int l = max, r = sum;
        int mid, ans = sum;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (isValid(nums, k, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }

    public boolean isValid(int[] nums, int k, int mid) {
        int count = 1;
        int subSum = 0;

        for (int i : nums) {
            subSum += i;
            if (subSum > mid) {
                count++;
                subSum = i;
                
                if (count > k) return false;
            }
        }

        return true;
    }
}