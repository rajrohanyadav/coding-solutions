# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.result = 0

        def diaOfNode(root: Optional[TreeNode]) -> int:
            left, right = 0, 0
            if not root:
                return 0
            if not root.left and not root.right:
                return 0
            if root.left:
                left = 1 + diaOfNode(root.left)
            if root.right:
                right = 1 + diaOfNode(root.right)
            self.result = max(self.result, left + right)
            return max(left, right)
        
        diaOfNode(root)
        return self.result