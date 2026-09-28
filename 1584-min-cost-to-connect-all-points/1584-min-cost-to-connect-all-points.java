class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});
        int minCost = 0;
        int edges = 0;
        while(edges < n){
            int[] top = pq.remove();
            int node = top[0];
            int cost = top[1];
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            edges++;
            minCost += cost;
            for(int i=0;i<n;i++){
                if(i != node && !vis[i]){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[node][0];
                    int y2 = points[node][1];
                    int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    pq.add(new int[]{i, dis});
                }
            }
        }
        return minCost;
    }
}