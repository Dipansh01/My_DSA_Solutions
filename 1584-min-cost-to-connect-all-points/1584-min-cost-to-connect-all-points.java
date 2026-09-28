class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, -1, 0});
        int minCost = 0;
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int node = top[0];
            int parent = top[1];
            int cost = top[2];
            if(vis[node]){
                continue;
            }
            vis[node] = true;
            minCost += cost;
            for(int i=0;i<n;i++){
                if(i != node && i != parent && !vis[i]){
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[node][0];
                    int y2 = points[node][1];
                    int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    pq.add(new int[]{i, node, dis});
                }
            }
        }
        return minCost;
    }
}