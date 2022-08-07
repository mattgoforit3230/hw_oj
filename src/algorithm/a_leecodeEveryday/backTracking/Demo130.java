package algorithm.a_leecodeEveryday.backTracking;

public class Demo130 {
    //130. 被围绕的区域
    int[] dx = {1,0,0,-1};
    int[] dy = {0,1,-1,0};
    public void solve(char[][] board) {
        int[][] visied = new int[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            if(board[i][0] == 'O')dfs(board,i,0,visied);
            if(board[i][board[0].length-1] == 'O')dfs(board,i,board[0].length-1,visied);
        }
        for (int i = 1; i < board[0].length-1; i++) {
            if(board[0][i] == 'O')dfs(board,0,i,visied);
            if(board[board.length-1][i] == 'O')dfs(board,board.length-1,i,visied);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O' && visied[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j,int[][] visied) {
        if(i < 0 || i > board.length-1 || j < 0 || j > board[0].length-1 || 'X' == board[i][j])return;
        if(visied[i][j] == 1)return;
        if(board[i][j] == 'O'){
            visied[i][j] = 1;
            for (int k = 0; k < 4; k++) {
                dfs(board,i+dx[k],j+dy[k],visied);
            }
        }
    }
}
