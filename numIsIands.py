class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        r,c = len(grid), len(grid[0])
        island = 0

        def dfs(grid, i, j):

            if i<0 or j<0 or i>=r or j>=c or grid[i][j]=="0":
                return
            
            grid[i][j] = "0"
            dfs(grid,i+1,j)
            dfs(grid,i,j+1)
            dfs(grid,i-1,j)
            dfs(grid,i,j-1)

        for x in range(len(grid)):
            for y in range(len(grid[0])):
                if grid[x][y]=="1":
                    island+=1
                    dfs(grid,x,y)
        
        return island

