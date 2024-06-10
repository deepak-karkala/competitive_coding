/*
2395. Find Subarrays With Equal Sum
Solved
Easy
Topics
Companies
Hint
Given a 0-indexed integer array nums, determine whether there exist two subarrays of length 2 with equal sum. Note that the two subarrays must begin at different indices.

Return true if these subarrays exist, and false otherwise.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

class FindSubarraysEqualSum {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length - 1; i++) {
            if (!set.add(nums[i] + nums[i + 1])) return true;
        }
        return false;
    }
}