/*
1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit
*/

import java.util.*;

class LongestSubarrayDiffLimit {
	/*
	Approach: Tree Map with two pointers
		1. Stores in natural order of keys
			=> Smallest: First, LArgest: Last
		2. Whenever diff exceeds limit, update left pointer
	Time: O(nlogn) Space: O(n)
	*/
    private static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int start = 0;
        int res = Integer.MIN_VALUE;

        for(int end = 0; end < nums.length; end++){
        	// Insert count
        	map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

        	if (map.lastEntry().getKey() - map.firstEntry().getKey() > limit) {
        		map.put(nums[start], map.get(nums[start]) - 1);
        		if (map.get(nums[start]) == 0) map.remove(nums[start]);
        		start++;
        	}
        	res = Math.max(res, end-start+1);
        }
        return res;
    }


    /*
	Approach: 2 Deque with two pointers
		1. Use maxDeque, minDeque to keep track of max, min
			=> maxDeque.peekFirst -> Max, minDeque.peekFirst -> Min
		2. Whenever diff exceeds limit, update left pointer
	Time: O(n) Space: O(n)
	*/
    private static int longestSubarrayDeque(int[] nums, int limit) {
    	Deque<Integer> maxDeque = new ArrayDeque<>();
    	Deque<Integer> minDeque = new ArrayDeque<>();
    	int start = 0, res = Integer.MIN_VALUE;

    	for(int end = 0; end<nums.length; end++) {
    		while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[end]) {
    			maxDeque.pollLast();	//removeLast() can also be used
    		}

    		while (!minDeque.isEmpty() && minDeque.peekLast() > nums[end]) {
    			minDeque.pollLast();
    		}

    		maxDeque.offer(nums[end]);
    		minDeque.offer(nums[end]);

    		while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
    			if (maxDeque.peekFirst() == nums[start]) maxDeque.pollFirst();
    			if (minDeque.peekFirst() == nums[start]) minDeque.pollFirst();
    			start++;
    		}

    		res = Math.max(res, end-start+1);
    	}
    	return res;
    }

    public static void main(String[] args) {
    	int[] nums = {8,2,4,7};
    	int limit = 4;
    	System.out.println(longestSubarrayDeque(nums, limit));
    }
}