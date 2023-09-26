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
    public boolean isValidBST(TreeNode root) {
       return solve(root, Integer.MIN_VALUE-1l, Integer.MAX_VALUE+1l);   
    }
    
    private boolean solve(TreeNode root, long min, long max) {
        
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;
        
        boolean ans = true;
        ans = ans && solve(root.left, min, Math.min(max, root.val));
        ans = ans && solve(root.right, Math.max(min, root.val), max);
        return ans;
    }
    
}