/*
713. Subarray Product Less Than K
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k
*/

class NumSubarrayProductLessThanK {
    /*
    Approach: Sliding window, 2 pointers template
    Time: O(n) Space:O(1)
    */
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, currProd = 1, count = 0;

        for(int end = 0; end<nums.length; end++) {
        	currProd *= nums[end];

        	while (start<=end && currProd >= k) {
        		currProd /= nums[start++];
        	}

        	count += end-start+1;
        }
        return count;
    }

    public static void main(String[] args) {
    	int[] nums = {10,5,2,6};
    	int k = 100;
    	System.out.println(numSubarrayProductLessThanK(nums, k));
    }
}