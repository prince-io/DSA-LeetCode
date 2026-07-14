class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int X = matrix[0].length;
        int Y = matrix.length;

        int x = X-1, y = 0;

        while (x >= 0 && y < Y) {
            if (matrix[y][x] == target) return true;
            else if (matrix[y][x] < target) y++;
            else x--;
        }

        return false;
    }
}