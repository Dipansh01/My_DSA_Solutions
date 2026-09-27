class Pair {
    int n;
    long t;
    Pair(int n, long t){
        this.n = n;
        this.t = t;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
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
            adjList.get(u).add(new Pair(v, t));
            adjList.get(v).add(new Pair(u, t));
        }
        int[] ways = new int[n];
        ways[0] = 1;
        int mod = 1_000_000_007;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.t, b.t));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int node = top.n;
            long t = top.t;
            if(t > time[node]){
                continue;
            }
            for(Pair p : adjList.get(node)){
                int adjNode = p.n;
                long adjTime = p.t;
                if(t + adjTime < time[adjNode]){
                    time[adjNode] = t + adjTime;
                    pq.add(new Pair(adjNode, t + adjTime));
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