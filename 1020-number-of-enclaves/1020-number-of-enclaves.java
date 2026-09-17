class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        for(int j=0;j<n;j++){
            if(grid[0][j] == 1 && !vis[0][j]){
                dfs(grid, vis, delRow, delCol, 0, j);
            }
            if(grid[m-1][j] == 1 && !vis[m-1][j]){
                dfs(grid, vis, delRow, delCol, m-1, j);
            }
        }
        
        for(int i=0;i<m;i++){
            if(grid[i][0] == 1 && !vis[i][0]){
                dfs(grid, vis, delRow, delCol, i, 0);
            }
            if(grid[i][n-1] == 1 && !vis[i][n-1]){
                dfs(grid, vis, delRow, delCol, i, n-1);
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid, boolean[][] vis, int[] delRow, int[] delCol, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow <= m-1 && ncol >= 0 && ncol <= n-1 && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                dfs(grid, vis, delRow, delCol, nrow, ncol);
            }
        }
    }
}