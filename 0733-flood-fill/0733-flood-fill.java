class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            dfs(image, sr, sc, color, image[sr][sc]);
        }
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int prevColor){
        int m = image.length;
        int n = image[0].length;
        if(sr < 0 || sr > m-1 || sc < 0 || sc > n-1 || image[sr][sc] != prevColor || image[sr][sc] == color){
            return;
        }
        image[sr][sc] = color;
        dfs(image,sr-1,sc,color,prevColor);
        dfs(image,sr,sc-1,color,prevColor);
        dfs(image,sr+1,sc,color,prevColor);
        dfs(image,sr,sc+1,color,prevColor);
    }
}