package com.leetcode.medium;

//304. Range Sum Query 2D - Immutable

// Calculate the sum of the elements of matrix inside the rectangle defined 
// by its upper left corner (row1, col1) and lower right corner (row2, col2).

//efficient
//Sum(ABCD)=Sum(OD)−Sum(OB)−Sum(OC)+Sum(OA)
class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length ==0) return;
        dp = new int[matrix.length +1][matrix[0].length+1];
        for(int i=0; i<matrix.length; ++i){
            for(int j=0; j<matrix[0].length; ++j){
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] + matrix[i][j] - dp[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2 +1][col1] + dp[row1][col1];
    }
}


//Slow
class NumMatrix {

    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<= row2; i++){
            for(int j=col1; j<=col2; j++){
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
