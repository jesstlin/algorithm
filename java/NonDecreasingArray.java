package com.leetcode.medium;

//665. Non-decreasing Array
//Input: nums = [4,2,3]
//Output: true
//Input: nums = [4,2,1]
//Output: false
//
//Guarantee: When decreasing happened, If the previous element in the array is less than the next element, we need to change the current element to the value of the next element
class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        boolean hasChanged = false;
        for( int i=0; i < nums.length -1; i++){
            
            if(nums[i] > nums[i+1]){
                if(hasChanged) return false;
                if (i!=0 && nums[i-1] > nums[i+1]){
                    nums[i+1] = nums[i];
                }
                hasChanged = true;
            }
            
        }
        return true;
    }
}
