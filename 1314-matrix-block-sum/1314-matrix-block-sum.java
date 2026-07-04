class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;

        int[][] ans = new int[r][c];
        int[][] pre = new int[r+1][c+1];

        int r1, r2, c1, c2;

        for (int i = 1; i < r+1; i++) {
            for (int j = 1; j < c+1; j++) {
                pre[i][j] = mat[i-1][j-1] + pre[i][j-1] + pre[i-1][j] - pre[i-1][j-1];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                r1 = Math.max(0, i-k) + 1;
                c1 = Math.max(0, j-k) + 1;
                r2 = Math.min(r-1, i+k) + 1;
                c2 = Math.min(c-1, j+k) + 1;

                ans[i][j] = pre[r2][c2] - pre[r2][c1-1] - pre[r1-1][c2] + pre[r1-1][c1-1];
            }
        }

        return ans;
    }
}