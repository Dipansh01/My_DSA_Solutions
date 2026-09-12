class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    bfs(grid, vis, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void bfs(char[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;
        while(!q.isEmpty()){
            int[] front = q.remove();
            int row = front[0];
            int col = front[1];

            // top
            if(row-1 >= 0){
                if(!vis[row-1][col] && grid[row-1][col] == '1'){
                    q.add(new int[]{row-1,col});
                    vis[row-1][col] = true;
                }
            }

            // bottom
            if(row+1 < m){
                if(!vis[row+1][col] && grid[row+1][col] == '1'){
                    q.add(new int[]{row+1,col});
                    vis[row+1][col] = true;
                }
            }

            // left
            if(col-1 >= 0){
                if(!vis[row][col-1] && grid[row][col-1] == '1'){
                    q.add(new int[]{row,col-1});
                    vis[row][col-1] = true;
                }
            }

            // right
            if(col+1 < n){
                if(!vis[row][col+1] && grid[row][col+1] == '1'){
                    q.add(new int[]{row,col+1});
                    vis[row][col+1] = true;
                }
            }
        }
    }
}