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
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        flag = true;
        check(root);
        return flag;
    }

    public int check(TreeNode n) {
        int l = 0;
        int r = 0;

        if (n.left != null)
            l = check(n.left);
        if (n.right != null)
            r = check(n.right);

        if (Math.abs(l - r) > 1)
            flag = false;

        return Math.max(l, r) + 1;
    }
}