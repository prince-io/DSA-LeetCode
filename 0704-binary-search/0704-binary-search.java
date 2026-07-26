// ITERATIVE APPROACH

// class Solution {
//     public int search(int[] nums, int target) {
//         int l = 0, r = nums.length-1, mid;

//         while (l <= r) {
//             mid = l + (r - l) / 2;
//             if (nums[mid] == target) return mid;
//             else if (nums[mid] < target) l = mid + 1;
//             else r = mid - 1;
//         }

//         return -1;
//     }
// }



// RECURSIVE APPROACH

class Solution {
    public int search(int[] nums, int target) {
        return bin(nums, target, 0, nums.length - 1);
    }

    public static int bin(int[] nums, int t, int l, int r) {
        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;

        if (nums[mid] == t)
            return mid;
        else if (nums[mid] < t)
            return bin(nums, t, mid + 1, r);
        else
            return bin(nums, t, l, mid - 1);
    }
}