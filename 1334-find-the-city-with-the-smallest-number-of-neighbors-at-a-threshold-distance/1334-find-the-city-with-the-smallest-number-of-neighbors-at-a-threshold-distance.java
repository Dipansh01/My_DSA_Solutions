class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dis[u][v] = w;
            dis[v][u] = w;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j || i==k || j==k || dis[i][k] == Integer.MAX_VALUE || dis[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(i != j && dis[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(minCount >= count){
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}