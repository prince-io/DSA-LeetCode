class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        fill(nums, 0, list, main);

        return main;
    }

    public static void fill(int[] nums, int start, List<Integer> list, List<List<Integer>> main) {
        main.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            fill(nums, i + 1, list, main);
            list.remove(list.size() - 1);
        }
    }
}