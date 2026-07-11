class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int n = position.length;
        int l = 1, r = position[n-1] - position[0];
        int mid, ans = r;

        while (l <= r) {
            mid = l + (r-l) / 2;
            if (isValid(position, m, mid)) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid - 1;
        }

        return ans;
    }

    public boolean isValid(int[] position, int m, int gap) {
        int balls = 1;
        int prev = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= gap) {
                balls++;
                prev = position[i];
            }
            if (balls == m) return true;
        }

        return balls >= m;
    }
}