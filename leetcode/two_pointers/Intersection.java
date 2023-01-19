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
        int[] intr = intersection_sort(nums1, nums2);
        System.out.println(Arrays.toString(intr));
    }
}
