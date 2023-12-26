/*
283. Move Zeroes
Easy
Topics
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array
*/

class MoveZeroes {
	/*
	Approach: 2 pointers (fast, slow)
	Time: O(n) Space:O(1)
	*/
    private static void moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int i=0; i<nums.length; i++) {
        	if (nums[i] != 0) nums[insertPos++] = nums[i];
        }

        while(insertPos < nums.length) nums[insertPos++] = 0;
        return;
    }

    public static void main(String[] args) {
    	int[] nums = {0,1,0,3,12};
    	moveZeroes(nums);
    	for(int i: nums) System.out.print(i + " ");
    }
}