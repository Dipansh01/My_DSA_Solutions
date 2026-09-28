class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        int[] timeTaken = new int[n+1];
        for(int i=0;i<=n;i++){
            timeTaken[i] = Integer.MAX_VALUE;
        }
        timeTaken[src] = 0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<times.length;j++){
                int u = times[j][0];
                int v = times[j][1];
                int t = times[j][2];
                if(timeTaken[u] != Integer.MAX_VALUE && timeTaken[u] + t < timeTaken[v]){
                    timeTaken[v] = timeTaken[u] + t;
                }
            }
        }
        int maxTime = 0;
        for(int i=1;i<=n;i++){
            if(timeTaken[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxTime = Math.max(maxTime, timeTaken[i]);
        }
        return maxTime;
    }
}