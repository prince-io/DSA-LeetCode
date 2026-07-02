class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] arr = new int[10001];
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = m-1; i >= 0; i--) {
            int curr = nums2[i];
            while (!stk.isEmpty() && stk.peek() <= curr) stk.pop();

            if (stk.isEmpty()) arr[curr] = -1;
            else arr[curr] = stk.peek();

            stk.push(curr);
        }

        for (int i = 0; i < n; i++) ans[i] = arr[nums1[i]];

        return ans;
    }
}