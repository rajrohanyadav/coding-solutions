func maxAreaOfIsland(grid [][]int) int {
    maxArea := 0
    for r := range grid {
        for c := range grid[0] {
            if grid[r][c] == 1 {
                if a := dfs(r, c, &grid); a > maxArea {
                    maxArea = a
                }
            }
        }
    }
    return maxArea
}

func dfs(r int, c int, grid *[][]int) int {
    if (r < 0) || (r == len(*grid)) || (c < 0) || (c == len((*grid)[0])) {
        return 0
    }
    if ((*grid)[r][c] == 0) {
        return 0
    }
    (*grid)[r][c] = 0
    return (1 + dfs(r+1, c, grid) +
                dfs(r-1, c, grid) +
                dfs(r, c+1, grid) +
                dfs(r, c-1, grid))
}