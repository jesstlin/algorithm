//Delete Operation for Two Str 
//Using largest common subsequence

//583. Delete Operation for Two Strings
//Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
//In one step, you can delete exactly one character in either string.

//m + n - 2 * lcs()

//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Input: word1 = "leetcode", word2 = "etco"
//Output: 4
  
//Time complexity : O(2^{max(m,n)}) 
// O(2max(m,n)). Size of recursion tree will be 2^(m+n). 
// Here, mm and nn refer to the lengths of s1s1 and s2s2 respectively.
//Space complexity : O(max(m,n)). The depth of the recursion tree will go upto max(m,n).
//Slow
class DeleteOperation4TwoStrUsingLCS {
    public int minDistance(String word1, String word2) {
        // m + n + 2*lcs
        //larget common subsequence
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length());
        
    }
    
    int lcs(String s1, String s2, int m, int n){
        if( m ==0 || n ==0 )
            return 0;
        if( s1.charAt(m-1) == s2.charAt(n-1) )
            return 1 + lcs(s1, s2, m-1, n-1);
        else
            return Math.max( lcs(s1, s2, m, n -1), lcs(s1, s2, m-1, n));
        
    }
}

//a lot of redundant function calls are made, since the same mm and nn values to be used for the function calls 
// could be obtained going through many different paths. 
//remove this redundancy by making use of a memomemo array to store the value to be returned for these function calls 
// if they have been called once with the corresponding parameters.

//By returning the already stored values from the memomemo array, we can prune the search space to a great extent.


//Time complexity : O(m∗n). memo array of size m x n needs to be filled once. 
// Here, m and n refer to the length of the strings s1 and s2 respectively.

//Space complexity :O(m∗n). memo array of size m x n is used. 
// Also, The depth of the recursion tree will go upto max(m,n).
class DeleteOperation4TwoStrUsingLCSNoRedundancy{
    public int minDistance(String word1, String word2) {
        // m + n + 2*lcs
        //larget common subsequence
        int[][] table = new int[word1.length() +1][word2.length()+1];
        
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length(), table);
        
    }
    
    int lcs(String s1, String s2, int m, int n, int[][] table){
        if( m ==0 || n ==0 )
            return 0;
        if( table[m][n] >0)
            return table[m][n];
        if( s1.charAt(m-1) == s2.charAt(n-1))
            table[m][n] = 1 + lcs(s1, s2, m-1, n-1, table);
        else
            table[m][n] = Math.max( lcs(s1, s2, m, n -1, table), lcs(s1, s2, m-1, n, table));
        return table[m][n];
    }
}
