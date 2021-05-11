package com.leetcode.medium;

//1143. Longest Common Subsequence

//Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
//Input: text1 = "abcde", text2 = "ace" 
//Output: 3 (ace)
//Input: text1 = "abc", text2 = "def"
//Output: 0 ()
//Input: text1 = "abc", text2 = "abc"
//Output: 3 (abc)


class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] matrix = new int[text1.length()+1][text2.length()+1];
        
        return lcs(matrix, text1, text2, text1.length(), text2.length());
    }
    
    int lcs(int[][] matrix, String s1, String s2, int m, int n){
        
        if(m==0 || n==0)
            return 0;
        if( matrix[m][n]>0 )
            return matrix[m][n]; 
        
        if(s1.charAt(m-1) == s2.charAt(n-1))
            matrix[m][n] = 1 + lcs(matrix, s1, s2, m-1, n-1);
        else
            matrix[m][n] = Math.max(lcs(matrix, s1, s2, m -1, n), lcs(matrix, s1, s2, m, n-1));
       
        return matrix[m][n];  
    }
}
