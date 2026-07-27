class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (n == 0) {
            if (m % 2 == 0)
                return (double) (nums1[m / 2] + nums1[(m / 2) - 1]) / 2;
            else
                return (double) nums1[m / 2];
        }

        if (m == 0) {
            if (n % 2 == 0)
                return (double) (nums2[n / 2] + nums2[(n / 2) - 1]) / 2;
            else
                return (double) nums2[n / 2];
        }

        int medIdx = (m + n) / 2;
        int i = 0, j = 0;

        int processed = 0;
        double p1 = 0, p2 = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                p2 = p1;
                p1 = nums1[i];
                i++;
            }

            else {
                p2 = p1;
                p1 = nums2[j];
                j++;
            }

            processed++;

            if (processed > medIdx)
                break;
        }

        if (i < m && processed <= medIdx) {
            while (processed <= medIdx) {
                p2 = p1;
                p1 = nums1[i];
                i++;
                processed++;
            }
        }

        if (j < n && processed <= medIdx) {
            while (processed <= medIdx) {
                p2 = p1;
                p1 = nums2[j];
                j++;
                processed++;
            }
        }

        if ((m + n) % 2 == 1)
            return p1;
        else
            return (p1 + p2) / 2;
    }
}