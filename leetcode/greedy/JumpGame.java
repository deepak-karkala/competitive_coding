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
    private static boolean canJump_dp_memo_top(int[] nums) {
    	int[] dp = new int[nums.length];
    	for(int i=0; i<dp.length; i++) dp[i] = -1;
        return canJump_dp_memo(nums, 0, dp);
    }

    private static boolean canJump_dp_memo(int[] nums, int curr_idx, int[] dp) {
    	// Return memoised value if previously computed
    	if (dp[curr_idx] != -1) return dp[curr_idx]==1 ? true: false;

    	// If goes beyond last index => no jump to last index
    	if (curr_idx > nums.length-1) {
    		dp[curr_idx] = 0;
    		return false;
    	}

    	// If reaches last index, return true
    	if (curr_idx == nums.length-1) {
    		dp[curr_idx] = 1;
    		return	true;
    	}

    	// Iterate from 1 to max num of jumps from this index
    	for(int i=curr_idx+1; i<=curr_idx+nums[curr_idx]; i++) {
    		if (canJump_dp_memo(nums, i, dp)) {
    			dp[curr_idx] = 1;
    			return true;
    		}
    	}

    	dp[curr_idx] = 0;
    	return false;
    }


    /*
    	DP bottom up
		Start from last index and keep checking if last index can be reached
		=> Time: O(N^2) Space:O(N)
    */
    private static boolean canJump_dp_bottomup(int[] nums) {
    	boolean[] dp = new boolean[nums.length];
    	dp[nums.length-1] = true;

    	for (int i=nums.length-2; i>=0; i--) {
    		//if (nums[i]==0) dp[i] = false;
    		for (int j=i+1; j<i+nums[i]+1; j++) {
    			if (j<nums.length && dp[j]) dp[i] = true;
    		}

    	}
    	return dp[0];
    }

    public static void main(String[] args) {
    	int[] nums = {0,2,3};
    	System.out.println(canJump_dp_bottomup(nums));
    }
}