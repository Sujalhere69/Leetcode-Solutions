class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original != color){
            helper(image , sr , sc , original , color);
        }
        return image;
    }
    public void helper(int [] [] image , int i , int j , int original , int color){
        if(i<0 ||i>=image.length || j<0 || j>=image[0].length || image[i][j] != original || image[i][j]==color){
            return ;
        }
        image[i][j]=color;
        helper(image , i-1,j , original , color);
        helper(image , i+1,j , original , color);
        helper(image , i,j-1 , original , color);
        helper(image , i,j+1, original , color);
    }
}