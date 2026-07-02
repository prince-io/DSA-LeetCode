class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int target = nums[i];
            int x = i+1, y = n-1;
            while (x < y) {
                int sum = nums[x] + nums[y];
                if (sum < (-1 * target)) x++;
                else if (sum > (-1 * target)) y--;
                else {
                    List<Integer> list = new ArrayList<>(Arrays.asList(target, nums[x], nums[y]));
                    Collections.sort(list);
                    if (!seen.contains(list)) {
                        seen.add(list);
                        ans.add(list);
                    }
                    x++;
                    y--;
                }
            }
        }
        
        return ans;
    }
}