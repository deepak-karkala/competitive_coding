/*
154. Find Minimum in Rotated Sorted Array II
Hard
Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
*/

class FindMinRotatedSortedArray2 {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        if (nums[low] < nums[high]) return nums[low];

        while(low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) low = mid + 1;
            else if (nums[mid] < nums[high]) high = mid;
            else high--;
        }
        return nums[low];
    }
}