/*
560. Subarray Sum Equals K
Attempted
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

import java.util.*;

class SubarraySum {
    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sumTillI = 0, count = 0;

        for(int i=0; i<nums.length; i++) {
            sumTillI += nums[i];

            if (map.containsKey(sumTillI - k)) count += map.get(sumTillI - k);

            map.put(sumTillI, map.getOrDefault(sumTillI, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3};
    	int k = 3;
    	System.out.println(subarraySum(nums, k));
    }
}