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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return max;
    }

    public int getSum(TreeNode n) {
        if (n.left == null && n.right == null) {
            max = Math.max(max, n.val);
            return n.val;
        }

        int l = 0;
        int r = 0;

        if (n.left != null)
            l = getSum(n.left);
        if (n.right != null)
            r = getSum(n.right);

        l = Math.max(0, l);
        r = Math.max(0, r);

        max = Math.max(max, n.val + l + r);
        return n.val + Math.max(l, r);
    }
}