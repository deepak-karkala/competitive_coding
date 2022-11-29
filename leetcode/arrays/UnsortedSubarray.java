import java.util.Arrays;

/*
Given an integer array nums, you need to find one continuous subarray
 that if you only sort this subarray in ascending order, then the
 whole array will be sorted in ascending order.
Return the shortest such subarray and output its length.
*/

public class UnsortedSubarray {
    
    public static int unsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];

        int start = -1;
        int end = len-1;

        for (int i=1; i<len; i++) {
            // Update max as we go from left to right
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                start = i;
            }
            // Update min as we go from right to left
            if (nums[len-1-i] <= min) {
                min = nums[len-1-i];
            } else {
                end = len-1-i;
            }
        }
        System.out.println(start);
        System.out.println(end);

        return Math.max(0, start-end+1);
    }

    public static int unsortedSubarraySort(int[] nums) {
        int[] nums_sorted = nums.clone();
        Arrays.sort(nums_sorted);

        int len = nums.length;
        int start = 0;
        int end = len-1;

        while(start < len && nums[start]==nums_sorted[start]) start++;
        while(end > start && nums[end]==nums_sorted[end]) end--;
        return end-start+1;
    }

    public static void main(String[] args) {
        //int[] nums = {2,6,4,8,10,9,15};
        int[] nums = {1, 2, 3, 3};

        int len = unsortedSubarraySort(nums);
        System.out.println(len);
    }
}
