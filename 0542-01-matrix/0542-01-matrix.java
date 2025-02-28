import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        // Add all 0s to the queue and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    dist[newRow][newCol] = dist[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }

        return dist;
    }
}



// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length ; 
//          int n = mat[0].length;
//          int matrix[][]= new int [m][n];
//          for(int i =0 ; i<m ; i++){
//             for(int j =0 ; j<n ; j++){
//                 if(mat[i][j]==0){
//                      matrix[i][j]=0;
//                 }else{
//                     matrix[i][j]= Bfs(i , j , mat , 0);
//                 }
//             }
//          }
// return matrix;
//     }
//     public int Bfs(int row , int col , int [][]mat , int count){
//         if(row >= 0 || row<mat.length || col >=0 || col < mat[0].length){
//             Queue<Pair> q = new LinkedList<>();
//             q.add(new Pair(row , col , count+1));
//             int rowa[]={0,0,-1,1};
//             int cola[]={-1,1,0 ,0};
//             for(int i =0 ; i<=3 ; i++){
//                 if(mat[row+i][col+j]==)
//             }
//         }
//     }
//     class Pair{
//         int row ;
//         int col ;
//         int count;
//         Pair(int row , int col , int count ){
//             this.row = row ; 
//              this.col = col ; 
//              this.count = count;
//         }
//     }
// }