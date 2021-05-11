package com.leetcode.medium;
// 55. Jump Game

//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.

// Input: [0]
// Output: ture
// Input: [2,0]
// Output: ture
// Input: [0,1]
// Output: false
// Input: [3,2,1,1,4]
// Output: ture
// Input: [3,2,1,0,4]
// Output: false

//greedy solution
// look backward if it can reach to the last end position
class JumpGame {
    
    public boolean canJump(int[] nums) {
        int lastGoodPos = nums.length -1;
        for(int i = nums.length-1; i >=0  ; --i){
           if( i + nums[i] >= lastGoodPos){
               lastGoodPos = i;
            }
        }
        
        return lastGoodPos == 0;
    }
}

//Time Limit Exceeded
// inefficient solution , tried every jump
class JumpGame_recursive {
    
    public boolean canJump(int[] nums) {
        return canJumpFrom( 0, nums);
    }
    
    boolean canJumpFrom ( int pos, int[] nums){
        if( pos == nums.length -1){
            return true;
        }
        
        int nextPossiblePos = Math.min( pos+nums[pos], nums.length -1);
        for( int next= pos +1; next <= nextPossiblePos; next++){
            if(canJumpFrom(next, nums)){
                return true;
            }
        }
        return false;
    }
}
