class Solution {
    public int[] lmax(int[] arr, int n) {
        int[] l = new int[n];
        l[0] = arr[0];
        for (int i = 1; i < n; i++) l[i] = Math.max(l[i-1], arr[i]);
        return l;
    }

    public int[] rmax(int[] arr, int n) {
        int[] r = new int[n];
        r[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) r[i] = Math.max(r[i+1], arr[i]);
        return r;
    }

    public int trap(int[] height) {
        int n = height.length;
        int water = 0;
        int[] l = lmax(height, n);
        int[] r = rmax(height, n);

        for (int i = 1; i < n-1; i++) {
            water += Math.min(l[i], r[i]) - height[i];
        }

        return water;
    }
}