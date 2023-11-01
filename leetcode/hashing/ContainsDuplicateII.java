/*
219. Contains Duplicate II
Easy
Topics
Companies
Given an integer array nums and an integer k, return true if there are two
distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
*/

import java.util.*;

class ContainsDuplicateII {
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashSet<Integer> hset = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
        	if (i > k) hset.remove(nums[i - k - 1]);
        	if (!hset.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,1,2,3};
    	int k = 2;
    	System.out.println(containsNearbyDuplicate(nums, k));
    }
}