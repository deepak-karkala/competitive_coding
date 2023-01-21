import java.util.Arrays;
import java.util.HashMap;

/*
 * Sort Colors
Medium
13.6K
498
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, 
white, and blue, respectively.

You must solve this problem without using the library's sort function.
 */
public class SortColors {
    // Doesn’t work because hashmat iterate is unordered
    public static int[] sortColors_hashmap(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        for(Integer num: nums) {
            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num)+1);
            } else {
                hm.put(num, 1);
            }
        }

        for(int key: hm.keySet()) {
            int i=0;
            while(i < hm.get(key)) nums[i++] = key;
        }
        return nums;
    }

    public static int[] sortColors(int[] nums) {
        int low = 0, i = 0, high = nums.length-1;

        while (i<=high) {
            if (nums[i] == 0) {
                swap(nums, low, i);
                low++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            } else {
                i++;
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        nums = sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
