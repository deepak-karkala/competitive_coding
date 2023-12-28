/*
287. Find the Duplicate Number
Medium
Topics
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
*/

import java.util.*;

class FindDuplicate {
    private static int findDuplicate1(int[] nums) {
		Arrays.sort(nums);

		for(int i=1; i<nums.length; i++) {
			if (nums[i] == nums[i-1]) return nums[i];
		}
		return nums[nums.length-1];       
    }

    private static int findDuplicate2(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			if (map.get(nums[i]) > 1) return nums[i];
    	}
		return nums[nums.length-1];       
    }

    public static void main(String[] args) {
    	int[] nums = {1,3,4,2,2};
    	System.out.println(findDuplicate2(nums));
    }
}