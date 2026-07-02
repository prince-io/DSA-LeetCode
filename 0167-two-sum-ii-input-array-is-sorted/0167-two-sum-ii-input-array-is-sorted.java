class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;


        while (i <= j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) j--;
            else if (sum < target) i++;
            else {
                int[] arr = {i+1, j+1};
                return arr;
            }
        }

        return new int[] {-1};
    }
}