/*
704. Binary Search
Solved
Easy
Topics
Companies
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.
*/

class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public int searchRecursive(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        return binarySearch(nums, target, low, high);
    }

    public int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;

        if (target == nums[mid]) return mid;
        else if (target > nums[mid]) return binarySearch(nums, target, mid + 1, high);
        else return binarySearch(nums, target, low, mid - 1);
    }
}

