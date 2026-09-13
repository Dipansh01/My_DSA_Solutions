class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        boolean[] vis = new boolean[n];
        int res = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj, vis, i);
                res++;
            }
        }
        return res;
    }
    public void dfs(int[][] adj, boolean[] vis, int i){
        int n = adj.length;
        vis[i] = true;
        for(int j=0;j<n;j++){
            if(adj[i][j] == 1 && !vis[j]){
                dfs(adj, vis, j);
            }
        }
    }
}