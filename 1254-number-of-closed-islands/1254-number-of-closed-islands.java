class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0){
                dfs(grid, i, 0);
            }
            if(grid[i][n-1] == 0){
                dfs(grid, i, n-1);
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j] == 0){
                dfs(grid, 0, j);
            }
            if(grid[m-1][j] == 0){
                dfs(grid, m-1, j);
            }
        }
        int res = 0;
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(grid[i][j] == 0){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 1){
            return;
        }
        grid[row][col] = 1;
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}