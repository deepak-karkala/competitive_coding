/*
905. Sort Array By Parity
Easy
Topics
Companies
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
*/

class SortArrayByParity {
    private static int[] sortArrayByParity(int[] nums) {
        int readPtr = 0, writePtr = 0;

        for(; readPtr < nums.length; readPtr++) {
        	if (nums[readPtr] % 2 == 0) {
        		int tmp = nums[readPtr];
        		nums[readPtr] = nums[writePtr];
        		nums[writePtr] = tmp;
        		writePtr++;
        	}
        }
        return nums;
    }

    public static void main(String[] args) {
		int[] nums = {3, 1, 2, 4};
		int[] arr = sortArrayByParity(nums);
		for(int i: arr) System.out.print(i + " ");
    }
}