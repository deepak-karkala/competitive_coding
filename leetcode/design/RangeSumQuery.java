/*
303. Range Sum Query - Immutable
Solved
Easy
Topics
Companies
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
*/

class RangeSumQuery {
    int[] sumArray;
    public RangeSumQuery(int[] nums) {
        sumArray = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sumArray[i + 1] = sumArray[i] + nums[i];
    }
    
    public int sumRange(int left, int right) {
        return sumArray[right + 1] - sumArray[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */