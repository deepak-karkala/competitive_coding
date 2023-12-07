/*
643. Maximum Average Subarray I
Easy
Topics
Companies
You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
*/

class FindMaxAverage {
	/*
	Approach: Sliding window with standard 2 pointers template
	Time: O(n) Space: O(1)
	*/
    private static double findMaxAverage(int[] nums, int k) {
        long maxSum = Integer.MIN_VALUE, currSum = 0;
        int start=0, end=0;

        while(end < nums.length) {
        	currSum += nums[end];

        	if (end - start + 1 == k) {
        		maxSum = Math.max(maxSum, currSum);
        		currSum -= nums[start++];
        	}
        	end++;
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
    	int[] nums = {1,12,-5,-6,50,3};
    	int k = 4;
    	System.out.println(findMaxAverage(nums, k));
    }
}