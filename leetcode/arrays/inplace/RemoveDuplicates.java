/*
26. Remove Duplicates from Sorted Array
Solved
Easy
Topics
Companies
Hint
Given an integer array nums sorted in non-decreasing order, remove the duplicates
in-place such that each unique element appears only once. The relative order of the
elements should be kept the same. Then return the number of unique elements in nums.
*/

class RemoveDuplicates {
	// Array: inplace with read and write pointers
    private static int removeDuplicates(int[] nums) {
        int readPtr = 0, writePtr = 0, count = 0;

        while(readPtr < nums.length) {
        	if (readPtr == 0 || nums[readPtr] != nums[readPtr - 1]) nums[writePtr++] = nums[readPtr];
        	readPtr++;
        }

        return writePtr;
    }

    public static void main(String[] args) {
    	int[] nums = {0,0,1,1,1,2,2,3,3,4};
    	int val = 1;
    	System.out.println(removeDuplicates(nums));
    }
}