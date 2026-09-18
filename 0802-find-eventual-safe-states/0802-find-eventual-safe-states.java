class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                temp.add(graph[i][j]);
            }
            adjList.add(temp);
        }
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adjList, vis, pathVis, check, i);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfs(List<List<Integer>> adjList, boolean[] vis, boolean[] pathVis, boolean[] check, int src){
        vis[src] = true;
        pathVis[src] = true;
        for(int num : adjList.get(src)){
            if(!vis[num]){
                if(dfs(adjList, vis, pathVis, check, num)){
                    return true;
                }
            }
            else if(pathVis[num]){
                return true;
            }
        }
        check[src] = true;
        pathVis[src] = false;
        return false;
    }
}