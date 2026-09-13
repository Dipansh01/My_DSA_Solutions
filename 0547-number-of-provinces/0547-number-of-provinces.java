class Solution {
    public int findCircleNum(int[][] adj) {
        int n = adj.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i != j && adj[i][j] == 1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int res = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adjList, vis, i);
                res++;
            }
        }
        return res;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int i){
        vis[i] = true;
        for(int num : adjList.get(i)){
            if(!vis[num]){
                dfs(adjList, vis, num);
            }
        }
    }
}