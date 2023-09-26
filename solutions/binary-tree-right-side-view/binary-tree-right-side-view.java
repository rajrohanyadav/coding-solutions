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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (q.size() != 0) {
            int numQueue = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numQueue; i++) {
                TreeNode item = q.remove();
                temp.add(item.val);
                if (item.left != null) q.add(item.left);
                if (item.right != null) q.add(item.right);
            }
            res.add(temp.get(temp.size() - 1));
        }
        System.out.println(q);
        return res;
    }
}