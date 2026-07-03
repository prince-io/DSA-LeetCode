class Solution {
    public int getAns(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                if (map.get(nums[l]) == 1) map.remove(nums[l]);
                else map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }
            count += r-l+1;
            r++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return getAns(nums, k) - getAns(nums, k-1);
    }
}