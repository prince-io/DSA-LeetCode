class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] mat = new int[m][n];

        for (int[] arr : mat)
            Arrays.fill(arr, -1);

        return solve(m - 1, n - 1, obstacleGrid, mat);
    }

    public int solve(int m, int n, int[][] grid, int[][] mat) {
        if (grid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;

        if (mat[m][n] != -1)
            return mat[m][n];

        int x = 0, y = 0;

        if (n - 1 >= 0)
            x = solve(m, n - 1, grid, mat);
        if (m - 1 >= 0)
            y = solve(m - 1, n, grid, mat);

        mat[m][n] = x + y;

        return mat[m][n];
    }
}