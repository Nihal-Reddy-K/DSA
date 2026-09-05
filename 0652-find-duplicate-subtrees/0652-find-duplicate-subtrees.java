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

    HashMap<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        find(root);

        return result;
    }

    private String find(TreeNode node) {
        if (node == null) {
            return "#";
        }

        String left = find(node.left);

        String right = find(node.right);

        String current = node.val + "," + left + "," + right;
        int count = map.getOrDefault(current, 0);

        if (count == 1) {
            result.add(node);
        }
        map.put(current, count + 1);
        return current;
    }
}