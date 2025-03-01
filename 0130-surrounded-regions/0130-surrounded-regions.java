class Solution {

    public void dfs(int row , int col , int[] cola , int [] rowa , char[][]board , int [][] vis){
        vis[row][col]=1;
         for(int i =0 ; i<4 ;i++){
            int nrow =row +rowa[i];
            int ncol = col +cola[i];
            if(nrow>=0 && nrow<board.length && ncol>=0 && ncol <board[0].length && board[nrow][ncol] =='O' && vis[nrow][ncol]==0){
                
                    dfs(nrow , ncol , cola , rowa , board , vis );
                
            }
         }
    }
    public void solve(char[][] board) {
        int cola []= {-1,1,0,0};
        int rowa []= {0,0,-1,1};
        int n = board.length ; 
         int  m = board[0].length;
         int [][] vis = new int[n][m];
         for(int j =0 ; j<m; j++){
            if(vis[0][j]==0 && board[0][j]=='O'){
                dfs(0 , j ,cola , rowa , board , vis);
            }
            if(vis[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1 , j , cola , rowa , board , vis);
            }
         }
         for(int i =0 ; i<n ;i++){
            if(vis[i][0] == 0 && board[i][0]=='O'){
                dfs(i , 0 , cola , rowa , board , vis);
            }
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i , m-1 , cola , rowa , board , vis);
            }
         }

         for(int i =0 ; i<n ;i++){
            for(int j = 0 ; j< m ; j++){
                if(vis[i][j] ==1){
                    board[i][j]='O';
                }else{
                    board[i][j]='X';
                }
            }
         }
    }
}