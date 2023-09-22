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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diaOfNode(root);
        return result;
    }

    public int diaOfNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = 1 + diaOfNode(root.left); //2
        }
        if (root.right != null) {
            right = 1 + diaOfNode(root.right); //1
        }
        System.out.println(left + "" + right);
        result = Math.max(result, left + right);
        return Math.max(left, right);
    }
}