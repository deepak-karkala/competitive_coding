/*
27. Remove Element
Easy
Topics
Companies
Hint
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
*/

class RemoveElement {
	// Array: inplace with read and write pointers
    private static int removeElement(int[] nums, int val) {
        int writePtr = 0, readPtr = 0;
        int count = 0;

        for(; readPtr < nums.length; readPtr++) {
        	if (nums[readPtr] != val) {
        		nums[writePtr] = nums[readPtr];
        		writePtr++;
        	}
        }

        for(int i: nums) System.out.print(i + " ");
        return writePtr;
    }

    public static void main(String[] args) {
    	int[] nums = {1}; //{0,1,2,2,3,0,4,2};
    	int val = 1;
    	System.out.println(removeElement(nums, val));
    }
}