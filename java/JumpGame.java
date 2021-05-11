package com.leetcode.medium;
//45. Jump Game II
//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//You can assume that you can always reach the last index.

//Time Complexity: O(N) where N is the length of N
//Space Cmplexity: O(1)

//Input: nums = [2,3,1,1,4]
//Output: 2
//Input: nums = [2,3,0,1,4]
//Output: 2
//Input: nums = [10,9,8,7,6,5,4,3,2,1,1,0]
//Output: 2
//Input: nums = [0]
//Output: 0
class JumpGame {
    public int jump(int[] nums) {
        int len = nums.length - 1, curr = -1, next = 0, jumps = 0;
        for (int i = 0; next < len; i++) {
            if (i > curr) {
                jumps++;
                curr = next;
            };
            next = Math.max(next, nums[i] + i);
        };
        return jumps;
    }
}
