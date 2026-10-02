/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return check(root, targetSum, 0, map);
    }

    public int check(TreeNode n, int t, long s, HashMap<Long, Integer> map) {
        long sum = s + n.val;

        int count = map.getOrDefault(sum - t, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        if (n.left != null)
            count += check(n.left, t, sum, map);
        if (n.right != null)
            count += check(n.right, t, sum, map);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
        if (map.get(sum) == 0)
            map.remove(sum);

        return count;
    }
}