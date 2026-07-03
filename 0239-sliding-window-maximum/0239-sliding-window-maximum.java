class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) q.removeLast();
            q.addLast(i);
            if (q.peekFirst() == i-k) q.removeFirst();
            if (i >= k-1) arr[i-k+1] = nums[q.peekFirst()];
        }

        return arr;
    }
}