# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res
        q = collections.deque()
        q.append(root)
        numInLevel = 0
        while q:
            numInLevel = len(q)
            temp = []
            for i in range(numInLevel):
                node = q.popleft()
                temp.append(node)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            res.append(temp[-1].val)
        return res