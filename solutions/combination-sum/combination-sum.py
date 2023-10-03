class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        def findCombination(i, cur, total):
            if total == target:
                res.append(cur.copy())
                return
            if i >= len(candidates) or total > target:
                return
            cur.append(candidates[i])
            findCombination(i, cur, total + candidates[i])
            cur.pop()
            findCombination(i+1, cur, total)

        findCombination(0, [], 0)
        return res