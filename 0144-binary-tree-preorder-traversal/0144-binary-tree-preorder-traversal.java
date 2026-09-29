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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        if (root == null)
            return arr;

        preOrder(root, arr);
        return arr;
    }

    public void preOrder(TreeNode n, List<Integer> arr) {
        arr.add(n.val);

        if (n.left != null)
            preOrder(n.left, arr);

        if (n.right != null)
            preOrder(n.right, arr);
    }
}