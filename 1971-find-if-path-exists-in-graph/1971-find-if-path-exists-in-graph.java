class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination){
            return true;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        dfs(adj, vis, source, destination);
        return vis[destination];
    }
    public void dfs(List<List<Integer>> adj, boolean[] vis, int st, int ed){ 
        vis[st] = true;
        for(int num : adj.get(st)){
            if(!vis[num]){
                if(st == ed){
                    break;
                }
                dfs(adj, vis, num, ed);
            }
        }
    }
}