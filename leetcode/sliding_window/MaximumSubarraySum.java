/*
2461. Maximum Sum of Distinct Subarrays With Length K
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

import java.util.*;

class MaximumSubarraySum {
    private static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currSum = 0;
        int start = 0, end = 0;
        Set<Integer> set = new HashSet<Integer>();

        while(end < nums.length) {
        	int newVal = nums[end];

        	while((set.contains(newVal) || end-start+1 > k) && start < end) {
        		currSum -= nums[start];
        		set.remove(nums[start]);
        		start++;
        	}

        	currSum += nums[end];
        	set.add(nums[end]);

        	if (end-start+1 == k) maxSum = Math.max(maxSum, currSum);
        	end++;
        }
        return maxSum;
    }


    private static long maximumSubarraySum2(int[] nums, int k) {
    	long maxSum = 0, currSum = 0;
        int start = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<nums.length; i++) {
        	currSum += nums[i];
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);


        	if (i >= k-1) {
        		if (map.size() == k) maxSum = Math.max(maxSum, currSum);

        		currSum -= nums[i-k+1];
        		map.put(nums[i-k+1], map.getOrDefault(nums[i-k+1], 0) - 1);

        		if (map.get(nums[i-k+1]) == 0) map.remove(nums[i-k+1]);
        	}
        }
        return maxSum;
    }

    public static void main(String[] args) {
    	int[] nums = {1,5,4,2,9,9,9};
    	int k = 3;
    	System.out.println(maximumSubarraySum2(nums, k));
    }
}