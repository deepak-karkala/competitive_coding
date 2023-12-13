/*
992. Subarrays with K Different Integers
Hard
Topics
Companies
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.
*/
import java.util.*;

class SubarraysWithKDistinct {
	/*
	Approach: Sliding window, 2 pointer template
		1. Exactly(nums, k) = AtMost(k) - AtMost(k-1)
		2. AtMost(k) can be solved using sliding window
			with standard 2 pointers template
	Time: O(n) Space:O(k)
	*/
    private static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    private static int atMostK(int[] nums, int k) {
    	int start = 0, numAtMostK = 0;
    	Map<Integer, Integer> map = new HashMap<>();

    	for(int end = 0; end < nums.length; end++) {
    		map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

    		while(map.size() > k) {
    			map.put(nums[start], map.get(nums[start]) - 1);
    			if (map.get(nums[start]) == 0) map.remove(nums[start]);
    			start++;
    		}
    		//Number of subarrays, starting at start, ending at end, with atMost K
    		numAtMostK += (end-start+1); 
    	}
    	return numAtMostK;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,1,2,3};
    	int k = 2;
    	System.out.println(subarraysWithKDistinct(nums, k));
    }
}