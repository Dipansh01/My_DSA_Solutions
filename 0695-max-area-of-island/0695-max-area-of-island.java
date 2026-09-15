class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    bfs(grid, vis, i, j);
                }
            }
        }
        return maxArea;
    }
    public void bfs(int[][] grid, boolean[][] vis, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = true;
        int size = 0;
        while(!q.isEmpty()){
            int[] front = q.remove();
            int a = front[0];
            int b = front[1];
            size++;
            if(a-1 >= 0 && grid[a-1][b] != 0 && !vis[a-1][b]){
                q.add(new int[]{a-1, b});
                vis[a-1][b] = true;
            }
            if(a+1 < m && grid[a+1][b] != 0 && !vis[a+1][b]){
                q.add(new int[]{a+1, b});
                vis[a+1][b] = true;
            }
            if(b-1 >= 0 && grid[a][b-1] != 0 && !vis[a][b-1]){
                q.add(new int[]{a, b-1});
                vis[a][b-1] = true;
            }
            if(b+1 < n && grid[a][b+1] != 0 && !vis[a][b+1]){
                q.add(new int[]{a, b+1});
                vis[a][b+1] = true;
            }
        }
        maxArea = Math.max(maxArea, size);
    }
}