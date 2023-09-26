/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    
    TreeNode lca;
    
    private TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null) return null;
        
        var left = solve(root.left, p, q);
        var right = solve(root.right, p, q);

        if(root==p) {
            if(left==q || right==q) {
                lca = root;
                return null;
            }
        } else if (root==q){
            if(left==p || right==p){
                lca = root;
                return null;
            }
        }
        
        
        if((left==p && right==q) || (left==q && right==p)) {
            lca = root;
        }
        
        if(root==p || root==q) return root;
        
        if(left!=null) return left;
        return right;
        
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        solve(root, p, q);
        return lca;
        
    }
    
    
}