/*
Minimum Jumps To Reach End of an Array
Given an array of non-negative integers, A, of length N. You are initially positioned
at the first index of the array. Each element in the array represents your maximum jump
length at that position.

Return the minimum number of jumps required to reach the last index.

If it is not possible to reach the last index, return -1.
*/

class MinJump {

	// Method: Recursion
	// Recursion
	// At each position, there are nums[curr_pos] number of options to jump
	// (If nums[curr_pos]=3, can jump 3 steps, 2 steps, 1 step) => For loop
	// For each of the above options, we need to recurse at curr_pos + curr_jump_len and so on
	// Time: O(N^N), Space: O(1)
	private static int minjump_recursive_top(int[] nums) {
		int len = nums.length;
		return minjump_recursive(nums, len, 0);
	}

	private static int minjump_recursive(int[] nums, int len, int curr_pos){
		// Base case (Reached end of array, 0 jumps from here to end)
		if (curr_pos >= len-1) return 0;

		// Recursion
		// At each position, there are nums[curr_pos] number of options to jump
		// (If nums[curr_pos]=3, can jump 3 steps, 2 steps, 1 step) => For loop
		// For each of the above options, we need to recurse at curr_pos + curr_jump_len and so on
		int min_jumps = Integer.MAX_VALUE;
		int curr_jump_len = 1;
		while(curr_jump_len <= nums[curr_pos]) {
			min_jumps = Math.min(min_jumps, 1 + minjump_recursive(nums, len, curr_pos + curr_jump_len));
			curr_jump_len += 1;
		}
		return min_jumps;
	}

	// 
	public static void main(String[] args) {
		//int[] nums = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int[] nums = {2, 3, 1, 1, 4};
		int min_jumps = minjump_recursive_top(nums);
		System.out.println(min_jumps);
	}
}