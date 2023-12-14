/*
930. Binary Subarrays With Sum
Medium
Topics
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.
*/

import java.util.*;

class NumSubarraysWithSum {
	/*
	Approach: Prefix sum
	Time: O(n) Space: O(n)
	*/
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int sums = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int i=0; i<nums.length; i++) {
        	sums += nums[i];
        	if (map.containsKey(sums - goal)) {
        		count += map.get(sums - goal);
        	}
        	map.put(sums, map.getOrDefault(sums, 0) + 1);
        }
        return count;
    }

    /*
    Approach: Sliding window using atMost
    	1. Sum(goal) = AtMost(Goal) - AtMost(Goal-1)
    Time: O(n) Space:O(1)
    */
    private static int numSubarraysWithSum2(int[] nums, int goal) {
    	return atMost(nums, goal) - atMost(nums, goal-1);
    }

    private static int atMost(int[] nums, int goal) {
    	int start = 0, currSum = 0, count = 0;
    	for(int end = 0; end<nums.length; end++) {
    		currSum += nums[end];

    		while(start<=end && currSum > goal) {
    			currSum -= nums[start];
    			start++;
    		}
    		count += end-start+1;
    	}
    	return count;
    }

    public static void main(String[] args) {
    	int[] nums = {1,0,1,0,1};
    	int goal = 2;
    	System.out.println(numSubarraysWithSum2(nums, goal));
    }
}