class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, -1, 0, +1};
        for(int j=0;j<n;j++){
            if(board[0][j] == 'O' && !vis[0][j]){
                dfs(board, vis, delRow, delCol, 0, j);
            }
            
            if(board[m-1][j] == 'O' && !vis[m-1][j]){
                dfs(board, vis, delRow, delCol, m-1, j);
            }
        }
        
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                dfs(board, vis, delRow, delCol, i, 0);
            }
            
            if(board[i][n-1] == 'O' && !vis[i][n-1]){
                dfs(board, vis, delRow, delCol, i, n-1);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';                
                }
            }
        }
    }
    public void dfs(char[][] board, boolean[][] vis, int[] delRow, int[] delCol, int row, int col){
        int m = board.length;
        int n = board[0].length;
        vis[row][col] = true;
        for(int i=0;i<4;i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow <= m-1 && ncol >= 0 && ncol <= n-1 && board[nrow][ncol] == 'O' && !vis[nrow][ncol]){
                dfs(board, vis, delRow, delCol, nrow, ncol);
            }
        }
    }
}