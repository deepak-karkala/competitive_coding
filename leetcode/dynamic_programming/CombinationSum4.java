/*
Combination Sum IV
Solved
Medium
Topics
Companies
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
*/

class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];

        // 1 way to reach 0 without taking any elements
        memo[0] = 1;

        for(int j = 1; j <= target; j++) {
            for(int num: nums){
                if (j >= num) memo[j] += memo[j - num];
            }
        }
        return memo[target];
    }
}