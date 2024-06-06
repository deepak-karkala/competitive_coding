/*
1218. Longest Arithmetic Subsequence of Given Difference
Solved
Medium
Topics
Companies
Hint
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
*/

class LongestArithSubsequenceDiff {
    /*
    HashMap: to store the maximum length of subsequence ending at each number (arr[i])
    Map<arr[i], max len of subsequence with difference ending at this number>
    Keep incrementing this based on value of map at Map<arr[i] - difference, >
    */
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> memo = new HashMap<>();
        int maxLen = 0;

        for(int i = 0; i < arr.length; i++) {
            memo.put(arr[i], memo.getOrDefault(arr[i] - difference, 0) + 1);
            maxLen = Math.max(maxLen, memo.get(arr[i]));
        }
        return maxLen;
    }
}