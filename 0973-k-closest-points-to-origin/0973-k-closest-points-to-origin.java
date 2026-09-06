class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            int dis = x*x + y*y;
            pq.add(new int[]{dis,x,y});

            if(pq.size() > k){
                pq.remove();
            }
        }
        int ans[][] = new int[k][2];
        for(int i=0;i<k;i++){
            int[] top = pq.remove();
            ans[i][0] = top[1];
            ans[i][1] = top[2];
        }
        return ans;
    }
}