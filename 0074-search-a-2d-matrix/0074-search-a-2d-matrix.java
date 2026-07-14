class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int l = 0, r = n-1, mid, ans = -1;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (matrix[mid][0] <= target) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        if (ans == -1) return false;
        int x = 0, y = m-1;

        while (x <= y) {
            mid = x + (y-x) / 2;
            if (matrix[ans][mid] == target) return true;
            else if (matrix[ans][mid] < target) x = mid + 1;
            else y = mid - 1;
        }

        return false;
    }
}