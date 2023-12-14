/*
974. Subarray Sums Divisible by K
Medium
Topics
Companies
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
*/

class SubarraysDivByK {
    private static int subarraysDivByK(int[] nums, int k) {
    	int[] map = new int[k];
    	map[0] = 1;
        int start = 0, currSum = 0, count = 0;

        for(int end = 0; end<nums.length; end++) {
        	currSum = (currSum + nums[end]) % k;
        	if (currSum < 0) currSum += k;
        	count += map[currSum];
        	map[currSum]++;
        }
        return count;
    }

    public static void main(String[] args) {
    	int[] nums = {4,5,0,-2,-3,1};
    	int k = 5;
    	System.out.println(subarraysDivByK(nums, k));
    }
}