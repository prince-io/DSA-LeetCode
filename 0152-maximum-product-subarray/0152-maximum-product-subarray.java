class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max1 = nums[0], max2 = nums[n-1];
        int prod = 1;

        for (int i = 0; i < n; i++) {
            prod *= nums[i];
            max1 = Math.max(max1, prod);
            if (prod == 0) prod = 1;
        }
        
        prod = 1;

        for (int j = n-1; j >= 0; j--) {
            prod *= nums[j];
            max2 = Math.max(max2, prod);
            if (prod == 0) prod = 1;
        }

        return Math.max(max1, max2);
    }
}