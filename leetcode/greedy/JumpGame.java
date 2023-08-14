/*
55. Jump Game
Medium
17.3K
938
Companies
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
*/


class JumpGame {
	/*
		Recursive
		For each index, max_jump can be upto n => So n options (for loop)
		For each of those n options, recurse further, depth = n
		=> Time: O(N^N) Space: O(N)
	*/
    private static boolean canJump_recursive_top(int[] nums) {
        return canJump_recursive(nums, 0);
    }

    private static boolean canJump_recursive(int[] nums, int curr_idx) {
    	// If goes beyond last index => no jump to last index
    	if (curr_idx > nums.length-1) return false;
    	// If reaches last index, return true
    	if (curr_idx == nums.length-1) return	true;

    	// Iterate from 1 to max num of jumps from this index
    	for(int i=curr_idx+1; i<=curr_idx+nums[curr_idx]; i++) {
    		if (canJump_recursive(nums, i)) return true;
    	}

    	return false;
    }


    /*
    	DP top down
		Same as above, compute once and store
		=> Time: O(N^2) Space:O(N)
    */
    

    
    public static void main(String[] args) {
    	int[] nums = {3,2,1,0,4};
    	System.out.println(canJump_recursive_top(nums));
    }
}