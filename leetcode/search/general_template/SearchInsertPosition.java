/*
35. Search Insert Position
Solved
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
*/

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }
}