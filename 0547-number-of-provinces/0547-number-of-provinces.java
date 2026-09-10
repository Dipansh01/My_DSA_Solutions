class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        int res = 0;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(adj, vis, i);
                res++;
            }
        }
        return res;
    }
    public void bfs(int[][] adj, boolean[] vis, int i){
        vis[i] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.remove();
            for(int j=0;j<adj.length;j++){
                if(!vis[j] && adj[front][j] == 1){
                    q.add(j);
                    vis[j] = true;
                }
            }
        }
    }
}