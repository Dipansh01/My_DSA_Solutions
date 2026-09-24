class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        efforts[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] direction = {{-1,0}, {+1,0}, {0,-1}, {0,+1}};
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int i = top[0];
            int j = top[1];
            int eff = top[2];
            for(int[] dir : direction){
                int row = i + dir[0];
                int col = j + dir[1];
                if(row >= 0 && row < m && col >= 0 && col < n){
                    int newEffort = Math.max(eff, Math.abs(heights[row][col] - heights[i][j]));
                    if(newEffort < efforts[row][col]){
                        efforts[row][col] = newEffort;
                        pq.add(new int[]{row, col, newEffort});
                    }
                }
            }
        }
        return efforts[m-1][n-1];
    }
}