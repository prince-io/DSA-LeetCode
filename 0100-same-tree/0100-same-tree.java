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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return check(p, q);
    }

    public boolean check(TreeNode p, TreeNode q) {
        boolean l = false;
        boolean r = false;

        if (p.left != null && q.left != null)
            l = check(p.left, q.left);
        else if (p.left == null && q.left == null)
            l = true;

        if (p.right != null && q.right != null)
            r = check(p.right, q.right);
        else if (p.right == null && q.right == null)
            r = true;

        if (p.val == q.val)
            return l && r;
        else
            return false;
    }
}