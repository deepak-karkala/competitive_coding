/*
485. Max Consecutive Ones
Easy
Topics
Companies
Hint
Given a binary array nums, return the maximum number of consecutive 1's in the array
*/


class MaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] nums) {
        int end = 0, currCount = 0, maxCount = 0;

        for(int i = 0; i < nums.length; i++) {
        	if (nums[i] == 1) currCount++;
        	else currCount = 0;
        	maxCount = Math.max(maxCount, currCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,0,1,1,1};
    	System.out.println(findMaxConsecutiveOnes(nums));
    }
}
