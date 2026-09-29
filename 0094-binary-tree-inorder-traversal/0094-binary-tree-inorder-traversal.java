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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        if (root == null)
            return arr;

        inOrder(root, arr);
        return arr;
    }

    public void inOrder(TreeNode n, List<Integer> arr) {
        if (n.left != null)
            inOrder(n.left, arr);

        arr.add(n.val);

        if (n.right != null)
            inOrder(n.right, arr);
    }
}