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
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;

        travel(root, targetSum);
        return count;
    }

    public void travel(TreeNode n, int t) {
        check(n, t, 0);

        if (n.left != null)
            travel(n.left, t);

        if (n.right != null)
            travel(n.right, t);

        return;
    }

    public void check(TreeNode n, int t, long s) {
        long sum = s + n.val;
        if (sum == t)
            count++;

        if (n.left != null)
            check(n.left, t, sum);
        if (n.right != null)
            check(n.right, t, sum);

        return;
    }
}