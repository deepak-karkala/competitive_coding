/*
1413. Minimum Value to Get Positive Step by Step Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.
*/


class MinStartValue {
    private static int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int n: nums) {
            sum += n;
            min = Math.min(min, sum);
        }
        return Math.max(1, 1 - min);
    }
}