/*
494. Target Sum
Solved
Medium
Topics
Companies
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.
*/

class TargetSumWays {
    /*
    1. At every index, either take +nums[i] or -nums[i] => Sounds like 1/0 Knapsack
    2. Recursion
        a. Number of ways to reach remaining_target at index i can be computed using,
        b. ways[i][remaining_target] = ways[i - 1][remaining_target + nums[i]] 
                + ways[i - 1][remaining_target - nums[i]]
    3. These are repeating subproblems => DP
    4. DP States
        a. Index till i 
        b. Target reached till now
    5. Details
        a. Hard to figure out bounds of Remaining target 
            => Cannot use array, instead of HashMap
        b. Array of Hashmap to store each indices
    6. Time: O(n) Space: O(n * )
    */
    public int findTargetSumWaysTopDown(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer>[] memo = new HashMap[n];
        for(int i = 0; i < nums.length; i++) memo[i] = new HashMap<Integer, Integer>();

        return dp(nums, target, n - 1, memo);
    }

    public int dp(int[] nums, int remaining_target, int index, Map<Integer, Integer>[] memo) {
        // Base cases
        if (index < 0 && remaining_target == 0) return 1;
        if (index < 0) return 0;

        // Memoised case
        if (memo[index].containsKey(remaining_target)) return memo[index].get(remaining_target);

        // Recursion
        memo[index].put(remaining_target, dp(nums, remaining_target - nums[index], index - 1, memo)
            + dp(nums, remaining_target + nums[index], index - 1, memo));

        return memo[index].get(remaining_target);
    }
}