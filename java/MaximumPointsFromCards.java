package com.leetcode.medium;

//1423. Maximum Points You Can Obtain from Cards

//There are several cards arranged in a row, and each card has an associated number of points The points are given in the integer array cardPoints.
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//Your score is the sum of the points of the cards you have taken.
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

//Input: cardPoints = [1,2,3,4,5,6,1], k = 3
//Output: 12
//Input: cardPoints = [1,1000,1], k = 1
//Output: 1
//Input: cardPoints = [9,7,7,9,7,7,9], k = 7
//Output: 55  
  
//Consider it's circle. take first window, then move to left 
//Time Complexity: O(K)
//Space Complexity: O(1)
class MaximumPointsFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int total =0;
        for(int i=0; i < k; i++){
            total +=cardPoints[i];
        }
        int best=total;
        
        for(int i= k-1, j =cardPoints.length-1; i >=0; i--, j--){
            total += cardPoints[j] - cardPoints[i];
            best = Math.max(total, best);
        }
        return best;
    }
}
