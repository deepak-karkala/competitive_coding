/*
312. Burst Balloons
Solved
Hard
Topics
Companies
You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.
*/

class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        int n = 1;
        for(int i: nums) arr[n++] = i;
        arr[0] = 1; arr[n++] = 1;

        // n = nums.length + 2; (to include two balloons at the edge)
        int[][] memo = new int[n][n];

        // Compute memo for every length from 1...n
        for(int len = 2; len < n; len++) {
            // For each len, go over all start indices
            for(int left = 0; left < n - len; left++) {
                // end index = start_index + len
                int right = left + len;

                int maxCoins = Integer.MIN_VALUE;
                // For a given start and end indices (nums[left:right]), 
                //      let 'last' be the last balloon that will be burst
                // When we consider each balloon to be last, one of them
                //      will be the optimal solution (lead to max coins)

                for(int last = left + 1; last < right; last++) {
                    int coinsLastBurst = arr[left] * arr[last] * arr[right];
                    int coinsLeftSubset = memo[left][last];
                    int coinsRightSubset = memo[last][right];

                    maxCoins = Math.max(maxCoins, coinsLastBurst + coinsLeftSubset + coinsRightSubset);
                }
                memo[left][right] = maxCoins;
            }
        }
        return memo[0][n - 1];
    }
}