/*
45. Jump Game II
Medium
13K
459
Companies
You are given a 0-indexed array of integers nums of length n.
You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated
such that you can reach nums[n - 1].
*/


class JumpGameII {

	/*
		Recursive
		For each index, max_jump can be upto n => So n options (for loop)
		For each of those n options, recurse further, depth = n
		=> Time: O(N^N) Space: O(N)
	*/
    private static int canJump_recursive_top(int[] nums) {
        return canJump_recursive(nums, 0);
    }

    private static int canJump_recursive(int[] nums, int curr_idx) {
    	// If reaches last index, return true
    	if (curr_idx == nums.length-1) return 0;

    	// Iterate from 1 to max num of jumps from this index
    	int min_jumps = Integer.MAX_VALUE;
    	if (nums[curr_idx] == 0) return min_jumps;

    	for(int i=curr_idx+1; i<=curr_idx+nums[curr_idx]; i++) {
    		if (i<nums.length) {
    			int num_jumps_from_i = canJump_recursive(nums, i);
    			if (num_jumps_from_i != Integer.MAX_VALUE) {
	    			min_jumps = Math.min(min_jumps, 1 + num_jumps_from_i);
	    		}
    		}
    	}
    	return min_jumps;
    }

    /*
    	DP top down
		Same as above, compute once and store
		=> Time: O(N^2) Space:O(N)
    */
    private static int canJump_dp_memo_top(int[] nums) {
    	int[] dp = new int[nums.length];
    	for(int i=0; i<nums.length; i++) dp[i] = -1;
        return canJump_dp_memo(nums, 0, dp);
    }

    private static int canJump_dp_memo(int[] nums, int curr_idx, int[] dp) {
    	// Return memoised value
    	if (dp[curr_idx] != -1) return dp[curr_idx];

    	// If reaches last index, return true
    	if (curr_idx == nums.length-1) return 0;

    	// Iterate from 1 to max num of jumps from this index
    	int min_jumps = Integer.MAX_VALUE;
    	if (nums[curr_idx] == 0) return min_jumps;

    	for(int i=curr_idx+1; i<=curr_idx+nums[curr_idx]; i++) {
    		if (i<nums.length) {
    			int num_jumps_from_i = canJump_dp_memo(nums, i, dp);
    			if (num_jumps_from_i != Integer.MAX_VALUE) {
	    			min_jumps = Math.min(min_jumps, 1 + num_jumps_from_i);
	    		}
    		}
    	}
    	return dp[curr_idx] = min_jumps;
    }

    /*
    	DP bottom up
		Same as above, compute once and store
		=> Time: O(N^2) Space:O(N)
    */
    private static int canJump_dp_bottomup(int[] nums) {
    	int[] dp = new int[nums.length];
    	for(int i=0; i<nums.length; i++) dp[i] = Integer.MAX_VALUE;

    	dp[nums.length-1] = 0;	// O steps from last index
    	
    	// Compute for each index starting from n-2 down to 0
    	for(int i=nums.length-2; i>=0; i--) {
    		int min_jumps = Integer.MAX_VALUE;
    		
    		// Iterate from 1 to max_jumps from this index
    		for(int j=i+1; j<=i+nums[i]; j++) {
    			if (j < nums.length) {
    				int num_jumps_from_i = dp[j];
    				if (num_jumps_from_i != Integer.MAX_VALUE) {
		    			dp[i] = Math.min(dp[i], 1+num_jumps_from_i);
		    		}
	    		}
    		}
    	}
    	return dp[0];
    }


	public static void main(String[] args) {
    	int[] nums = {2,3,0,1,4};
    	System.out.println(canJump_dp_bottomup(nums));
    }
}