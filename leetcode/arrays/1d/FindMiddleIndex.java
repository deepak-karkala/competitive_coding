/*
1991. Find the Middle Index in Array
Easy
Topics
Companies
Hint
Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).

A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].

If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.

Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
*/

class FindMiddleIndex {
    private static int findMiddleIndex(int[] nums) {
        int[] sumLeft = new int[nums.length + 1];
        int[] sumRight = new int[nums.length + 1];

        for(int i=0; i<nums.length; i++) {
        	sumLeft[i+1] = sumLeft[i] + nums[i];
        }

        for(int i=nums.length; i>=0; i--) {
        	if (i==nums.length) sumRight[i] = 0;
        	else sumRight[i] = sumRight[i+1] + nums[i];
        }

        for(int i=0; i<nums.length; i++) {
        	if (sumLeft[i] == sumRight[i+1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
    	int[] nums = {1,7,3,6,5,6};
    	System.out.println(findMiddleIndex(nums));
    }
}