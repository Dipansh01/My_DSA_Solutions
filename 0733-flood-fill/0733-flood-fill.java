class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        if(image[sr][sc] != color){
            int prev = image[sr][sc];
            image[sr][sc] = color;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sr,sc});
            while(!q.isEmpty()){
                int[] front = q.remove();
                int i = front[0];
                int j = front[1];
                if(i-1 >= 0 && image[i-1][j] == prev){
                    q.add(new int[]{i-1,j});
                    image[i-1][j] = color;
                }
                if(i+1 < m && image[i+1][j] == prev){
                    q.add(new int[]{i+1,j});
                    image[i+1][j] = color;
                }
                if(j-1 >= 0 && image[i][j-1] == prev){
                    q.add(new int[]{i,j-1});
                    image[i][j-1] = color;
                }
                if(j+1 < n && image[i][j+1] == prev){
                    q.add(new int[]{i,j+1});
                    image[i][j+1] = color;
                }
            }
        }
        return image;
    }
}