// class Solution {

// public void dfs(int row , int col , int[][]grid , int [][] matrix){
//     int drow[]={0,0 ,1,-1};
//     int dcol[]={-1 , 1 , 0 , 0};
//     matrix[row][col]=1;
//     grid[row][col]=0;
// for(int i =0 ;i<4;i++ ){
//     int nrow = row +drow[i];
//     int ncol = col + dcol[i];
//     if( nrow >=0 && nrow <matrix.length && ncol >=0 && ncol< matrix[0].length &&grid[nrow][ncol]==1 && matrix[nrow][ncol]==0){
//         dfs(nrow , ncol , grid , matrix);
//     }
// }

// }

//     public int numEnclaves(int[][] grid) {
//         int rows = grid.length ;
//         int column = grid[0].length ;
//         int [][] matrix= new int[rows][column];

// for(int i =0 ; i<rows ; i++){
//     if(grid[i][0] == 1 && matrix[i][0]==0){
//         dfs(i , 0 , grid , matrix);
//     }
//     if(grid[i][column-1] ==1 && matrix[i][column]==0){
//            dfs(i , column-1 , grid , matrix);
//     }
// }
// for(int j =0 ; j<column;j++){
//     if(grid[0][j]==1 && matrix[0][j]==0){
//         dfs(0 , j , grid , matrix);
//     }
//     if(grid[rows-1][j]==1 && matrix[rows-1][j]==0){
//             dfs(rows-1 , j , grid , matrix);
//     }
// }
// int count =0;
// for(int i =0 ; i<matrix[0].length ;i++){
//     for(int j =0 ; j<matrix.length ;j++){
//         if(matrix[i][j]==1){
//             count++;
//         }
//     }
// }
// return count;
//     }
// }
class Solution {
    public void dfs(int row, int col, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Direction vectors for left, right, down, up
        int[] drow = {0, 0, 1, -1};
        int[] dcol = {-1, 1, 0, 0};

        grid[row][col] = 0; // Mark visited by setting to 0

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Mark boundary land cells and their connected components
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, grid);
            }
            if (grid[i][cols - 1] == 1) {
                dfs(i, cols - 1, grid);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j, grid);
            }
            if (grid[rows - 1][j] == 1) {
                dfs(rows - 1, j, grid);
            }
        }

        // Count remaining land cells
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
