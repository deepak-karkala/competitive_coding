/*
673. Number of Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.
*/

class NumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];

        int numLIS = 0, maxLen = 0;

        for(int i = 0; i < nums.length; i++) {
            len[i] = 1; count[i] = 1;

            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // Found a subsequence of same length as what I already had
                    //      Add the count to current count
                    if (len[i] == len[j] + 1){
                        count[i] += count[j];
                    // Found a subsequence of longer length
                    //      Reset count to this
                    } else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } 
                }
            }

            // Update result if current len is max len so far
            if (maxLen == len[i]) numLIS += count[i];

            // If current len is max, Update maxLen 
            //      Reset result to current count
            if (maxLen < len[i]) {
                maxLen = len[i];
                numLIS = count[i];
            }
        }
        return numLIS;
    }
}