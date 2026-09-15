class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int res = -1;
        int[][] direction = {{-1,0}, {+1,0}, {0,-1}, {0,+1}};
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i=0;i<size;i++){
                int[] front = q.remove();
                for(int[] dir : direction){
                    int a = front[0] + dir[0];
                    int b = front[1] + dir[1];
                    if(a<0 || a>=m || b<0 || b>=n || grid[a][b]==0 || vis[a][b]){
                        continue;
                    }
                    vis[a][b] = true;
                    fresh--;
                    q.add(new int[]{a,b});
                }
            }
        }
        if(fresh == 0){
            return res;
        }
        return -1;
    }
}