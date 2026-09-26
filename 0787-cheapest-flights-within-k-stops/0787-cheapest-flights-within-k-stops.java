class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adjList.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }
        int[] minCost = new int[n];
        for(int i=0;i<n;i++){
            minCost[i] = Integer.MAX_VALUE;
        }
        minCost[src] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        while(!q.isEmpty()){
            int[] top = q.remove();
            int node = top[0];
            int cost = top[1];
            int stops = top[2];
            if(stops == k+1) {
                continue;
            }
            for(int[] num : adjList.get(node)){
                int newCost = cost + num[1];
                if(newCost < minCost[num[0]]){
                    minCost[num[0]] = newCost;
                    q.add(new int[]{num[0], newCost, stops+1});
                }
            }
        }
        if(minCost[dst] != Integer.MAX_VALUE){
            return minCost[dst];
        }
        return -1;
    }
}