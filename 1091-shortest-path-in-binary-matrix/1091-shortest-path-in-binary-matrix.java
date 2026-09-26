class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        int[][] path = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                path[i][j] = Integer.MAX_VALUE;
            }
        }
        path[0][0] = 1;
        int[][] direction = {{-1,-1}, {-1,0}, {-1,+1}, {0,-1}, {0,+1}, {+1,-1}, {+1,0}, {+1,+1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        while(!q.isEmpty()){
            int[] front = q.remove();
            int x = front[0];
            int y = front[1];
            int dis = front[2];
            if(x == m-1 && y == n-1){
                return dis;
            }
            if(dis > path[x][y]){
                continue;
            }
            for(int[] dir : direction){
                int row = x + dir[0];
                int col = y + dir[1];
                if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 0 && dis+1 < path[row][col]){
                    path[row][col] = dis + 1;
                    q.add(new int[]{row, col, dis+1});
                }
            }
        }
        return -1;
    }
}