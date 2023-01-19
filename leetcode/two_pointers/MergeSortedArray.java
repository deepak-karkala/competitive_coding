import java.util.ArrayList;
import java.util.Arrays;

/*
 * Merge Sorted Array
Easy
9K
832
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored
inside the array nums1. To accommodate this, nums1 has a length of m + n, where the
first m elements denote the elements that should be merged, and the last n elements
are set to 0 and should be ignored. nums2 has a length of n.
 */

public class MergeSortedArray {
    // Two pointers with two arrays
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        
        while((i>=0) && (j>=0)) {

            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else if (nums1[i] < nums2[j]) {
                nums1[k] = nums2[j--];
            }
            k--;
        }

        while (j>=0) nums1[k--] = nums2[j--];
        while (i>=0) nums1[k--] = nums1[i--];

        return nums1;
    }

    // TWo pointers with two arraylists
    public static int[] merge_list(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i=a.size()-1, j=b.size()-1, k=a.size()+b.size()-1;
        int idx = i+1;
        while(idx <= k) {
            a.add(idx,0);
            idx++;
        }
        
        while((i>=0) && (j>=0)) {
            if (a.get(i) >= b.get(j)) {
                a.set(k, a.get(i));
                i--;
            } else if (a.get(i) < b.get(j)) {
                a.set(k, b.get(j));
                j--;
            }
            k--;
        }

        
        while (j>=0) {
            a.set(k, b.get(j));
            k--;
            j--;
        }
        while (i>=0) {
            a.set(k, a.get(i));
            k--;
            i--;
        }
        
 
        int[] res = list_to_array(a);
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
        //int[] nums1 = {1,2,3,0,0,0};
        int m = 3,  n = 3;
        int[] nums2 = {1,2,5,6};
        //int[] res = merge(nums1, m, nums2, n);

        int[] nums1 = {2,7};
        ArrayList<Integer> a = new ArrayList<Integer>(nums1.length);
        for (int i : nums1) a.add(i);
        ArrayList<Integer> b = new ArrayList<Integer>(nums1.length);
        for (int i : nums2) b.add(i);

        int[] res = merge_list(a, b);
        System.out.println(Arrays.toString(res));
    }

}
