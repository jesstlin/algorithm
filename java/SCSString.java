package com.leetcode.hard
//1092. Shortest Common Supersequence
//
//Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences.  
// If multiple answers exist, you may return any of them.

// Input: str1 = "abac", str2 = "cab"
// Output: "cabac"
class SCSString {
     public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
  
        // dp[i][j] contains length of 
        // shortest supersequence 
        // for X[0..i-1] and Y[0..j-1] 
        int dp[][] = new int[m + 1][n + 1];
  
        // Fill table in bottom up manner 
        for (int i = 0; i <= m; i++) 
        {
            for (int j = 0; j <= n; j++) 
            {
                // Below steps follow recurrence relation 
                if (i == 0) 
                {
                    dp[i][j] = j;
                } 
                else if (j == 0) 
                {
                    dp[i][j] = i;
                } 
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) 
                {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else 
                {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
  
        // Following code is used to print 
        // shortest supersequence dp[m][n] stores the length of the shortest supersequence of X and Y 
        int index = dp[m][n];  //lenght of lcs 
        // string to store the shortest supersequence 
        char[] str = new char[index];
  
        // Start from the bottom right corner and one by one 
        // push characters in output string 
        int i = m, j= n;
        while (i > 0 && j > 0) 
        {
            // If current character in X and Y are same, then 
            // current character is part of shortest supersequence 
            if (str1.charAt(i-1) == str2.charAt(j-1))   
            {
                // Put current character in result 
                str[--index] = (str1.charAt(i-1));
                // reduce values of i, j and index 
                i--;
                j--;
            }
            // If current character in X and Y are different 
            else if (dp[i-1][j] > dp[i][j-1])
            {
                // Put current character of Y in result 
                str[--index] = str2.charAt(j-1);
                // reduce values of j and index 
                j--;
            } 
            else 
            {
                // Put current character of X in result 
                str[--index] = (str1.charAt(i-1));
                // reduce values of i and index 
                i--;
            }
        }
  
        // If Y reaches its end, put remaining characters 
        // of X in the result string 
        while (i > 0) 
        {
            str[--index] = str1.charAt(i-1);
            i--;
        }
  
        // If X reaches its end, put remaining characters 
        // of Y in the result string 
        while (j > 0 )
        {
            str[--index] = str2.charAt(j-1);
            j--;
        }
        return String.valueOf(str);
    }
}
