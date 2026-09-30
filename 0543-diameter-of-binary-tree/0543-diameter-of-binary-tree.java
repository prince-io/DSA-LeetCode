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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        travel(root);
        return max;
    }

    public int travel(TreeNode n) {
        int l = 0;
        int r = 0;

        if (n.left != null)
            l = travel(n.left);
        if (n.right != null)
            r = travel(n.right);

        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}