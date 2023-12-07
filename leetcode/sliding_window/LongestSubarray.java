/*
1493. Longest Subarray of 1's After Deleting One Element
Medium
Topics
Companies
Hint
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

class LongestSubarray {
	/*
	Approach: Sliding window with standard 2 pointers template
	Time: O(n) Space: O(1)
	*/
    private static int longestSubarray(int[] nums) {
        int start = 0, end = 0, currLen = 0, maxLen = 0;
        int numZeros = 0;

        while(end < nums.length) {
        	if (nums[end] == 0) numZeros++;
        	else currLen++;

        	while(numZeros > 1) {
        		if (nums[start] == 0) numZeros--;
        		else currLen--;
        		start++;
        	}
        	maxLen = Math.max(maxLen, currLen);
        	end++;
        }
        return Math.min(maxLen, nums.length-1);
    }

    public static void main(String[] args) {
    	int[] nums = {0,1,1,1,0,1,1,0,1};
    	System.out.println(longestSubarray(nums));
    }
}