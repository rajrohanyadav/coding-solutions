func combinationSum(candidates []int, target int) [][]int {
    var res [][]int
    dfs(0, []int{}, 0, candidates, &res, target)
    return res
}

func dfs(i int, cur []int, total int,candidates []int, res *[][]int, target int) {
    if total == target {
        *res = append(*res, append([]int{}, cur...))
        return
    }
    if (i >= len(candidates)) || (total > target) {
        return
    }

    cur = append(cur, candidates[i])
    dfs(i, cur, total + candidates[i], candidates, res, target)
    cur = cur[:len(cur)-1]
    dfs(i+1, cur, total, candidates, res, target)
}