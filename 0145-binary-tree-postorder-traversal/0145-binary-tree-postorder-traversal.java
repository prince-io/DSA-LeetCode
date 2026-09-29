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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        if (root == null)
            return arr;

        postOrder(root, arr);
        return arr;
    }

    public void postOrder(TreeNode n, List<Integer> arr) {
        if (n.left != null)
            postOrder(n.left, arr);

        if (n.right != null)
            postOrder(n.right, arr);

        arr.add(n.val);
    }
}