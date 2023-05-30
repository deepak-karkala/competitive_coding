/*
300. Longest Increasing Subsequence
Medium
17.3K
328
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
*/

class LongestIncreasingSubsequence {

	// Recursion
    private static int lengthOfLIS_recursion(int[] nums) {
    	int maxLen = 0;
    	for(int i=0; i<nums.length; i++) {
    		maxLen = Math.max(maxLen, lengthOfLIS_endingAtI(nums, i));
    	}
    	return maxLen;
    }

    private static int lengthOfLIS_endingAtI(int[] nums, int i){
    	//Base case
    	if (i==0) return 1;

    	//Recursive call
    	int maxLenEndingAtI = 1;
    	for(int j=0; j<i; j++) {
    		if (nums[i] > nums[j]) {
    			maxLenEndingAtI = Math.max(maxLenEndingAtI, 1 + lengthOfLIS_endingAtI(nums, j));
    		}
    	}
    	return maxLenEndingAtI;
    }

    /*
    // DP: Bottom up
    private static int lengthOfLIS_dp_bottomup(int[] nums) {
    	// Bottom up
    	int[] maxLenEndingAtI = new int[nums.length];
    	for (int i=0; i<nums.length; i++) maxLenEndingAtI[i] = 1;

    	for(int i=1; i<nums.length; i++) {
    		for(int j=0; j<i; j++) {
    			if (nums[i] > nums[j]) maxLenEndingAtI[i] = Math.max(maxLenEndingAtI[i], 1 + maxLenEndingAtI[j]);
    		}
    	}

    	int maxLen = 0;
    	for(int i=0; i<nums.length; i++) {
    		maxLen = Math.max(maxLen, maxLenEndingAtI[i]);
    	}
    	return maxLen;
    }
    */


    public static void main(String[] args) {
    	int[] arr = {10,9,2,5,3,7,101,18};
    	System.out.println(lengthOfLIS_recursion(arr));
    }
}