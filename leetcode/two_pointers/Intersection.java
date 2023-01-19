import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Intersection of Two Arrays
Given two integer arrays nums1 and nums2, return an array
of their intersection. Each element in the result must be
unique and you may return the result in any order.
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 */

public class Intersection {
    /*
     * Brute force: For every element in first array, iterate through entire second array O(n^2)
     */
    public static int[] intersection_bruteforce(int[] nums1, int[] nums2) {
        HashSet<Integer> intr = new HashSet<Integer>();

        for (int i=0; i<nums1.length; i++) {
            for (int j=0; j<nums2.length; j++) {
                if (nums1[i] == nums2[j]) intr.add(nums1[i]);
            }
        }
        int[] result = set_to_array(intr);
        return result;
    }

    /*
     * Sorting with two pointers: Sort both arrays, use two pointers for two arrays
        If nums1[i] > nums2[j] then j++
        If nums1[i] < nums2[j] then i++
        If nums1[i] = nums2[j], add element to list/set, and i++, j++
        O(nlogn)
     */
    public static int[] intersection_sort(int[] nums1, int[] nums2) {
        HashSet<Integer> intr = new HashSet<Integer>();
        //ArrayList<Integer> intr = new ArrayList<Integer>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while ((i<nums1.length) && (j<nums2.length)) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                intr.add(nums1[i]);
                i++;
                j++;
            }
        }
        
        int[] result = set_to_array(intr);
        //int[] result = list_to_array(intr);
        return result;
    }

    /*
     * Binary search: Sort first array
        For each element in second array, do a binary search in first array
        If it exists, add element to list/set
        O(nlogn)
     */
    public static int[] intersection_binarysearch(int[] nums1, int[] nums2) {
        HashSet<Integer> intr = new HashSet<Integer>();
        //ArrayList<Integer> intr = new ArrayList<Integer>();

        Arrays.sort(nums1);
        for(int i=0; i<nums2.length; i++) {
            if (binarysearch(nums1, nums2[i])) intr.add(nums2[i]);
        }

        int[] result = set_to_array(intr);
        //int[] result = list_to_array(intr);
        return result;
    }

    /*
     * Hashsets: One to store all elements of one array, other to store common elements
        Iterate through first array and add all elements to hash-set
        Iterate through second, if it exists in hash-set then add that element to another hash-set
        O(n) time with O(n) extra space
     */

    public static boolean binarysearch(int[] arr, int key) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = low + ((high-low)/2);

            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }


    public static int[] set_to_array(HashSet<Integer> hs) {
        int[] res = new int[hs.size()];
        int i = 0;
        for(Integer num: hs) {
            res[i++] = num;
        }
        return res;
    }

    public static int[] list_to_array(ArrayList<Integer> arl) {
        int[] res = new int[arl.size()];
        int i = 0;
        for(Integer num: arl) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intr = intersection_binarysearch(nums1, nums2);
        System.out.println(Arrays.toString(intr));
    }
}
