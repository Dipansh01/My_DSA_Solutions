class Pair {
    int node;
    int time;
    Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        int[] timeTaken = new int[n+1];
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
            timeTaken[i] = Integer.MAX_VALUE;
        }
        timeTaken[k] = 0;
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adjList.get(u).add(new Pair(v, t));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.time, b.time));
        pq.add(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            int topNode = top.node;
            int topTime = top.time;
            if(topTime > timeTaken[topNode]){
                continue;
            }
            for(Pair p : adjList.get(topNode)){
                if(p.time + topTime < timeTaken[p.node]){
                    timeTaken[p.node] = p.time + topTime;
                    pq.add(new Pair(p.node, p.time + topTime));
                }
            }
        }
        int res = 0;
        for(int i=1;i<=n;i++){
            if(timeTaken[i] == Integer.MAX_VALUE){
                return -1;
            }
            res = Math.max(res, timeTaken[i]);
        }
        return res;
    }
}