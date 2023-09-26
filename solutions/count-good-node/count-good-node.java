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
    
    int count = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return count;
    }

    private void traverse(TreeNode node, int maxTillNow) {

        if(node==null) return;
        if(maxTillNow <= node.val) {
            count++;
        }

        traverse(node.left, Math.max(maxTillNow, node.val));
        traverse(node.right, Math.max(maxTillNow, node.val));
    }
}