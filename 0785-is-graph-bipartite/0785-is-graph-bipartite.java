class Solution {
    static boolean res;
    public boolean isBipartite(int[][] graph) {
        res = true;
        int n = graph.length;
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i] == 0){
                bfs(graph, vis, i);
            }
        }
        return res;
    }
    public static void bfs(int[][] graph, int[] vis, int i){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 1;
        while(!q.isEmpty()){
            int front = q.remove();
            for(int ele : graph[front]){
                if(vis[ele] == vis[front]){
                    res = false;
                    return;
                }
                if(vis[ele] == 0){
                    q.add(ele);
                    vis[ele] = (vis[front] == 1) ? 2 : 1;
                }
            }
        }
    }
}