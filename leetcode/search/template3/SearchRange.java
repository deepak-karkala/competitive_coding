/*
34. Find First and Last Position of Element in Sorted Array
Solved
Medium
Topics
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
*/

class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums==null || nums.length==0) return result;

        result[0] = binaryFirstSearch(nums, target);
        result[1] = binaryLastSearch(nums, target);

        return result;
    }

    public static int binaryFirstSearch(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    public static int binaryLastSearch(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }

        return result;
    }
}