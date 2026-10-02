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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        List<Integer> arr = new ArrayList<>();
        check(root, targetSum, 0, arr, ans);

        return ans;
    }

    public void check(TreeNode n, int t, int s, List<Integer> arr, List<List<Integer>> ans) {
        int sum = s + n.val;
        arr.add(n.val);

        if (sum == t && n.left == null && n.right == null) {
            List<Integer> newList = new ArrayList<>(arr);
            ans.add(newList);
        }

        else {
            if (n.left != null)
                check(n.left, t, sum, arr, ans);
            if (n.right != null)
                check(n.right, t, sum, arr, ans);
        }

        arr.remove(arr.size() - 1);
        return;
    }
}