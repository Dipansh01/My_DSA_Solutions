class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        long[] time = new long[n];
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
            time[i] = Long.MAX_VALUE;
        }
        time[0] = 0;
        for(int i=0;i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];
            adjList.get(u).add(new int[]{v, t});
            adjList.get(v).add(new int[]{u, t});
        }
        int[] ways = new int[n];
        ways[0] = 1;
        int mod = 1_000_000_007;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] top = pq.remove();
            int node = (int)top[0];
            long t = top[1];
            if(t > time[node]){
                continue;
            }
            for(int[] num : adjList.get(node)){
                int adjNode = num[0];
                int adjTime = num[1];
                if(t + adjTime < time[adjNode]){
                    time[adjNode] = t + adjTime;
                    pq.add(new long[]{adjNode, t + adjTime});
                    ways[adjNode] = ways[node];
                }
                else if(t + adjTime == time[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }
}