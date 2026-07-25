class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];

        int start = Math.max(0, k - nums2.length);
        int end = Math.min(k, nums1.length);

        for (int i = start; i <= end; i++) {
            if (i <= nums1.length && k - i <= nums2.length) {
                int[] arr1 = getArr(nums1, i);
                int[] arr2 = getArr(nums2, k - i);

                int[] candidate = getNum(arr1, arr2, k);

                if (getBig(0, candidate, 0, ans))
                    ans = Arrays.copyOf(candidate, k);
            }
        }

        return ans;
    }

    public static int[] getArr(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k];
        int budget = n - k;
        Deque<Integer> stk = new ArrayDeque<>();

        for (int i : arr) {
            if (stk.isEmpty())
                stk.push(i);

            else {
                while (!stk.isEmpty() && stk.peek() < i && budget > 0) {
                    stk.pop();
                    budget--;
                }

                if (stk.size() < k)
                    stk.push(i);
                else
                    budget--;
            }
        }

        // for (int i = 0; i < budget; i++)
        //     stk.pop();

        for (int i = k - 1; i >= 0; i--)
            ans[i] = stk.pop();

        return ans;

    }

    public static int[] getNum(int[] arr1, int[] arr2, int k) {
        int[] val = new int[k];
        int i = 0, j = 0, z = 0;

        while (i < arr1.length || j < arr2.length) {
            if (getBig(i, arr1, j, arr2))
                val[z++] = arr1[i++];

            else
                val[z++] = arr2[j++];
        }

        return val;
    }

    public static boolean getBig(int i, int[] a, int j, int[] b) {
        while (i < a.length && j < b.length && a[i] == b[j]) {
            i++;
            j++;
        }

        if (i == a.length)
            return false;
        if (j == b.length)
            return true;

        return a[i] > b[j];
    }
}