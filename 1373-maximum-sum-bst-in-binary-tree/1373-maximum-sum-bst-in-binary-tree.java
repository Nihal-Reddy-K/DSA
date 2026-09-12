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

    int maxSum = 0;

    class Info {
        boolean isBST;
        int min;
        int max;
        int sum;

        Info(boolean isBST, int min, int max, int sum) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private Info helper(TreeNode root) {

        if (root == null) {
            return new Info(
                true,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                0
            );
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST &&
            right.isBST &&
            left.max < root.val &&
            right.min > root.val) {

            int sum = left.sum + root.val + right.sum;

            maxSum = Math.max(maxSum, sum);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(true, min, max, sum);
        }
        return new Info(false, 0, 0, 0);
    }
}