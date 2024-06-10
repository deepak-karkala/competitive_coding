/*
416. Partition Equal Subset Sum
Solved
Medium
Topics
Companies
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
*/

class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for(int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        sum /= 2;

        boolean[][] memo = new boolean[n + 1][sum + 1];

        // To form 0 sum is possible with any number of elements (don't take any)
        for(int i = 0; i < n + 1; i++) memo[i][0] = true;

        // When taking 0 elements, except 0 sum no other sum is possible
        for(int j = 1; j < sum + 1; j++) memo[0][j] = false;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < sum + 1; j++) {
                // Do not take nums[i] in subset
                memo[i][j] = memo[i - 1][j];

                if (j - nums[i - 1] >= 0) {
                    // Take nums[i] in subset
                    memo[i][j] = (memo[i][j] || memo[i - 1][j - nums[i - 1]]);
                }
            }
        }
        return memo[n][sum];
    }
}