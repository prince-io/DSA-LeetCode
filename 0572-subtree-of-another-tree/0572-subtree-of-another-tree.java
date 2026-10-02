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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return travel(root, subRoot);
    }

    public boolean travel(TreeNode x, TreeNode y) {
        boolean ans = false;

        if (x.val == y.val) {
            ans = check(x, y);
            if (ans)
                return ans;
        }

        if (x.left != null) {
            ans = travel(x.left, y);
            if (ans)
                return ans;
        }

        if (x.right != null) {
            ans = travel(x.right, y);
            if (ans)
                return ans;
        }

        return ans;
    }

    public boolean check(TreeNode n, TreeNode m) {
        boolean l = false;
        boolean r = false;

        if (n.left != null && m.left != null)
            l = check(n.left, m.left);
        else if (n.left == null && m.left == null)
            l = true;

        if (n.right != null && m.right != null)
            r = check(n.right, m.right);
        else if (n.right == null && m.right == null)
            r = true;

        if (n.val == m.val)
            return l && r;
        else
            return false;
    }
}