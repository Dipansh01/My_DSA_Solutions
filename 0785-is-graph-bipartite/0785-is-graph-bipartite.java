class Solution {
    static boolean res;
    public boolean isBipartite(int[][] graph) {
        res = true;
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(res == false){
                return res;
            }
            if(vis[i] == 0){
                vis[i] = 1;
                dfs(graph, vis, i);
            }
        }
        return res;
    }
    public static void dfs(int[][] graph, int[] vis, int i){
        for(int ele : graph[i]){
            if(vis[ele] == vis[i]){
                res = false;
                return;
            }
            if(vis[ele] == 0){
                vis[ele] = (vis[i] == 1) ? 2 : 1;
                dfs(graph, vis, ele);
                if(!res){
                    return;
                }
            }
        }
    }
}