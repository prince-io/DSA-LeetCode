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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return getSum(root, targetSum, 0);
    }

    public boolean getSum(TreeNode n, int t, int s) {
        int sum = s + n.val;

        if (sum == t && n.left == null && n.right == null)
            return true;

        boolean l = false;
        if (n.left != null)
            l = getSum(n.left, t, sum);
        if (l)
            return l;

        boolean r = false;
        if (n.right != null)
            r = getSum(n.right, t, sum);
        if (r)
            return r;

        return false;
    }
}