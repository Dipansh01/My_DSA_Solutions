class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] res = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i, j, 0});
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] front = q.remove();
            int a = front[0];
            int b = front[1];
            int dis = front[2];
            res[a][b] = dis;
            if(a-1 >= 0 && !vis[a-1][b]){
                q.add(new int[]{a-1, b, dis+1});
                vis[a-1][b] = true;
            }
            if(a+1 < m && !vis[a+1][b]){
                q.add(new int[]{a+1, b, dis+1});
                vis[a+1][b] = true;
            }
            if(b-1 >= 0 && !vis[a][b-1]){
                q.add(new int[]{a, b-1, dis+1});
                vis[a][b-1] = true;
            }
            if(b+1 < n && !vis[a][b+1]){
                q.add(new int[]{a, b+1, dis+1});
                vis[a][b+1] = true;
            }
        }
        return res;
    }
}