class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(grid, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        vis[i][j] = true;
        if(i-1 >= 0 && grid[i-1][j] == '1' && !vis[i-1][j]){
            dfs(grid, vis, i-1, j);
        }
        if(i+1 <= m-1 && grid[i+1][j] == '1' && !vis[i+1][j]){
            dfs(grid, vis, i+1, j);
        }
        if(j-1 >= 0 && grid[i][j-1] == '1' && !vis[i][j-1]){
            dfs(grid, vis, i, j-1);
        }
        if(j+1 <= n-1 && grid[i][j+1] == '1' && !vis[i][j+1]){
            dfs(grid, vis, i, j+1);
        }
    }
}