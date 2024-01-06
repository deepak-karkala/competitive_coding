/*
80. Remove Duplicates from Sorted Array II
Medium
Topics
Companies
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place
such that each unique element appears at most twice. The relative order of the elements
should be kept the same.
*/

class RemoveDuplicatesII {
	// Array: inplace with read and write pointers
    private static int removeDuplicates(int[] nums) {
        int readPtr = 0, writePtr = 0, currCount = 0, count = 0;

        while(readPtr < nums.length) {
        	if (readPtr == 0 || nums[readPtr] != nums[readPtr - 1]) {
        		nums[writePtr++] = nums[readPtr];
        		currCount = 1;
        	} else {
        		currCount++;
        		if (currCount <= 2) nums[writePtr++] = nums[readPtr];
        	}
        	readPtr++;
        }
        return writePtr;
    }

    public static void main(String[] args) {
    	int[] nums = {0,0,1,1,1,1,2,3,3};
    	int val = 1;
    	System.out.println(removeDuplicates(nums));
    }
}