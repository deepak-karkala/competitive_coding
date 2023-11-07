/*
217. Contains Duplicate
Easy
Topics
Companies
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
*/

import java.util.*;

class ContainsDuplicate {
    private static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int n: nums)
			if (!set.add(n)) return true;
		return false;        
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,1};
    	System.out.println(containsDuplicate(nums));
    }
}