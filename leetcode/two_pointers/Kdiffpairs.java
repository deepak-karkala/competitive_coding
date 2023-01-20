import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
 * K-diff Pairs in an Array
Medium
3.1K
2.2K
Given an array of integers nums and an integer k,
return the number of unique k-diff pairs in the array.
Example 1:

Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
*/

/*
Brute force - 
        Iterate through every pair, don’t include already included pairs - O(n^2)
Hashset - 
        to reduce search time from O(n) to O(1) with O(n) extra space
        Iterate through array and put everything in hash-set
        Iterate again, search for arr[i] + kdiff and arr[i] - knife and increment count accordingly
        To prevent duplicate entries, remove arr[i] from hash-set
        Return count of unique pairs
        O(n)
Sort with two pointers - O(nlogn)
        Sort array
        Two pointers, i=0; j=1;
        If arr[j] - arr[i] < k j++
        If arr[j] - arr[i] > k i++ if i==j then j++
        If arr[i] - arr[j] == k, then increment count, i=j, j=j+1
        Once there is a k-diff at i,j then for all elements l = i+1, i+2,…j-1 arr[l] - arr[j]
        will be less than k, so we can skip all those elements and restart the search at arr[j], arr[j+1]
        O(nlogn)
Binary search
 */

public class Kdiffpairs {
    public static int kdiffpairs_binarysearch(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int count = 0;
        int i = 0, j = 1;

        // Binary search
        Arrays.sort(nums);
        for (; i<nums.length; i++) {
            if ((i>0) && (nums[i]==nums[i-1])) continue; // Skip repeated elements
            if (binarySearch(nums, i+1, nums.length-1, nums[i]+k)) count++; // Search

        }
        return count;
    }

    public static int kdiffpairs_twopointers(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int count = 0;
        int i = 0, j = 1;
        
        Arrays.sort(nums);
        while ((i<j) && (j < nums.length)) {

            if ((i>0) && (nums[i]==nums[i-1])) {
                i++;
            } else {
                if ((nums[j] - nums[i]) < k) {
                    j++;
                } else if ((nums[j] - nums[i]) > k) {
                    i++;
                } else {
                    count++;
                    i++;
                }
            }
            if (i==j) j++;
        }
        
        return count;
    }


    public static int kdiffpairs_hashset(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int count = 0;
        
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> rep = new HashSet<Integer>();
        for (int num: nums) {
            if (hs.contains(num)) rep.add(num);
            hs.add(num);
        }
        if (k==0) return rep.size();

        for(Integer ele: hs) {
            if (hs.contains(ele + k)) count++;
        }
        return count;
    }

    public static int kdiffpairs_hashmap(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int count = 0;

        return count;
    }

    public static boolean binarySearch(int[] arr, int low, int high, int key) {
        //int low = 0, high = arr.length-1;

        while(low <= high) {
            int mid = low + (high-low)/2;

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

    public static void main(String[] args) {
        //int[] nums = {1,2,4,4,3,3,0,9,2,3};
        //int[] nums = {3,1,4,1,5};
        int[] nums = {1,2,3,4,5};
        int k = 1;
        System.out.println(kdiffpairs_twopointers(nums, k));
    }
}
