/*
 * There is an integer array nums sorted in ascending order
 *  (with distinct values). Prior to being passed to your 
 * function, nums is possibly rotated at an unknown pivot 
 * index k (1 <= k < nums.length) such that the resulting 
 * array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], 
 * nums[1], ..., nums[k-1]] (0-indexed). For example, 
 * [0,1,2,4,5,6,7] might be rotated at pivot index 3 and 
 * become [4,5,6,7,0,1,2]. Given the array nums after the 
 * possible rotation and an integer target, return the index
 *  of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity.
 */
public class RotatedSortedArraySearch {
    
    public static int rotatedSortedArraySearch(int[] nums, int target) {
        if (nums==null || nums.length==0) return -1;
        if (nums.length==1) {
            return nums[0]==target ? 0:-1;
        }

        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) return mid;

            if (nums[low] <= nums[mid]) {
                if ((nums[low] <= target) && (target <= nums[mid])) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            } else {
                if ((nums[mid] <= target) && (target <= nums[high])) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }

        }
        return -1;
        //return nums[low]==target ? low:-1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotatedSortedArraySearch(nums, target));
    }
}
