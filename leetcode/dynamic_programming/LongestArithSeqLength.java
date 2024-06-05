/*
1027. Longest Arithmetic Subsequence
Solved
Medium
Topics
Companies
Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
*/

class LongestArithSeqLength {
    /*
    1. AS: Arithmetic Subsequence
    2. There can be AS with different diff, goal is to find one with max len
    3. memo[diff] -> is one dimension
    4. Can we use memo[i:j-1] to compute memo[i:j] ?
    5.  Yes - Based on diff= arr[i] - arr[i-1], increment memo[diff]+1
    6. memo[ind][diff] -> second dimension => Max len AS till index ind with difference diff
    7. For each i = 0, 1, ... len, need to use j = 0, 1,... i -1
    8. => Repeating subproblems => DP needed
    9. DP details: diff can be very large, using arr for memo can be wasteful
        => Use hashmap for memo
        Key -> diff
        Value -> len
        Use array of hashmaps to store all the indices
    10. Time: O(n^2), Space: O(n^2)
    */

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer>[] memo = new HashMap[n];

        int longestLen = 2;
        // For each index till arr.length
        for(int idx = 0; idx < n; idx++) {
            memo[idx] = new HashMap<>();

            // Loop through subarrays arr[0, 1, ... i-1]
            for(int i = 0; i < idx; i++) {
                int diff = nums[idx] - nums[i];
                memo[idx].put(diff, memo[i].getOrDefault(diff, 1) + 1);
                longestLen = Math.max(longestLen, memo[idx].get(diff));
            }
        }
        return longestLen;
    }
}