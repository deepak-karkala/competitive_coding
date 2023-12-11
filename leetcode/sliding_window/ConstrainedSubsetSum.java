/*
1425. Constrained Subsequence Sum
Hard
Topics
Companies
Hint
Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.

A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.
*/

import java.util.*;

class ConstrainedSubsetSum {
	/*
		Approach: DP + Heap (Sliding window)
		1. dp[i] = nums[i] + max(0, dp[i-k], dp[i-k+1],...,dp[i-1])
				(Max sum ending at i, if nums[i] is included in the sequence)
		2. Use heap (deque) to optimize finding the max
				Heap returns max in O(1)
		3. Keep updating left pointer, when sliding window is invalid
				when j-i > k
	*/
    private static int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0, res = Integer.MIN_VALUE;

        for(int end = 0; end<nums.length; end++) {
        	nums[end] += !deque.isEmpty() ? deque.peek() : 0;
        	res = Math.max(res, nums[end]);

        	while(!deque.isEmpty() && nums[end] > deque.peekLast())
        		deque.pollLast();

        	if (nums[end] > 0) deque.offer(nums[end]);

        	if (end>=k && !deque.isEmpty() && deque.peek()==nums[end-k])
        		deque.poll();
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {10,2,-10,5,20}; 
    	int k = 2;
    	System.out.println(constrainedSubsetSum(nums, k));
    }
}