/*
1004. Max Consecutive Ones III
Medium
Topics
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's
in the array if you can flip at most k 0's
*/


class LongestOnes {
	/*
	Approach: Sliding window: Two pointers
		1. Standard two pointer template
		2. Keep moving end pointer until window is invalid
		3. Keep moving start pointer towards right until window becomes valid
		4. Keep track of max/min
	Time: O(n) Space: O(1)
	*/
    private static int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, currLen = 0, maxLen = 0, numZerosFlipped = 0;

        while(end < nums.length) {
        	if (nums[end] == 0) numZerosFlipped++;

        	while(numZerosFlipped > k) {
        		maxLen = Math.max(maxLen, end-start);
        		if (nums[start] == 0) numZerosFlipped--;
        		start++;
        	}
        	end++;
        }
        return Math.max(maxLen, end-start);
    }

    public static void main(String[] args) {
    	int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
    	int k = 3;
    	System.out.println(longestOnes(nums, k));
    }
}