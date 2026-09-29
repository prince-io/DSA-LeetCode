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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        if (root.left == null || root.right == null)
            return false;

        return check(root.left, root.right);
    }

    public boolean check(TreeNode p, TreeNode q) {
        boolean x = false;
        boolean y = false;

        if (p.left != null && q.right != null)
            x = check(p.left, q.right);
        else if (p.left == null && q.right == null)
            x = true;

        if (p.right != null && q.left != null)
            y = check(p.right, q.left);
        else if (p.right == null && q.left == null)
            y = true;

        if (p.val == q.val)
            return x && y;
        else
            return false;
    }
}