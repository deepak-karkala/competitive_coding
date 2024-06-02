/*
198. House Robber
Solved
Medium
Topics
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];

        /*
        int[] amount = new int[nums.length + 1];
        amount[0] = 0;
        amount[1] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            amount[i + 1] = Math.max(amount[i - 1] + nums[i], amount[i]);
        }
        return amount[nums.length];
        */

        int prev_two = 0;
        int prev_one = nums[0];
        int max_amount = 0;
        for(int i = 1; i < nums.length; i++) {
            max_amount = Math.max(prev_two + nums[i], prev_one);
            prev_two = prev_one;
            prev_one = max_amount;
        }
        return max_amount;
    }
}