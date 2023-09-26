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
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        return solve(preorder, inorder, 0, n-1, 0, n-1);
    }
    
    
    private TreeNode solve(int[] preorder, int[] inorder, int lp, int rp, int li, int ri) {

        if(lp>rp) return null;
        if(lp==rp) {
            return new TreeNode(preorder[lp]);
        }
        
        TreeNode node = new TreeNode(preorder[lp]);
        int inOrderIndex = findIndex(inorder, preorder[lp]);
        
        int size = inOrderIndex - li;
        int n = preorder.length;
        
        if(lp+1<n)
            node.left = solve(preorder, inorder, lp+1, lp+size, li, inOrderIndex-1);
        if(lp+size+1<n)
            node.right = solve(preorder, inorder, lp+size+1, rp, inOrderIndex+1, ri);
        
        return node;
        
    }
    
    
    private int findIndex(int[] arr, int val) {
        for(int i=0;i<arr.length;i++) 
            if(arr[i]==val) return i;
        return -1;
    }
    
    
}