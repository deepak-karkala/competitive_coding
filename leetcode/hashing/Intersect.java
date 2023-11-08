/*
350. Intersection of Two Arrays II
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their intersection. 
Each element in the result must appear as many times as it shows in both arrays and
you may return the result in any order.
*/
import java.util.*;

class Intersect {
	/*
		Use hashmap, to map integers to number of occurrences
	*/
    private static int[] intersect1(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		List<Integer> res = new ArrayList<>();

		for(int n: nums1) map1.put(n, map1.getOrDefault(n, 0) + 1);
		for(int n: nums2) map2.put(n, map2.getOrDefault(n, 0) + 1);

		for(Integer digit: map1.keySet()) {
			//int digit = entry.getKey();
			if (map2.containsKey(digit)) {
				int numCommonOccurrences = Math.min(map2.get(digit), map1.get(digit));
				for(int i=0; i<numCommonOccurrences; i++) res.add(digit);
			}
		}
		
		int[] arr = new int[res.size()];
		for(int i=0; i<arr.length; i++) arr[i] = res.get(i);
		return arr;
    }


    /*
    	Sort both arrays and use two pointers
    */
    private static int[] intersect2(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	List<Integer> list = new ArrayList<>();

    	int i=0, j=0;
    	while(i < nums1.length && j < nums2.length) {
    		if (nums1[i] > nums2[j]){
    			j++;
    		} else if (nums1[i] < nums2[j]) {
    			i++;
    		} else {
    			list.add(nums1[i]);
    			i++;
    			j++;
    		}
    	}

    	int[] arr = new int[list.size()];
		for(i=0; i<arr.length; i++) arr[i] = list.get(i);
		return arr;
    }


    /*
    	Sort shorter array and use binary search 
    		(can load elements batchwise or stream from disk)
    private static int[] intersect3(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	List<Integer> list = new ArrayList<>();

    	for(int i=0; i<nums2.length; i++) {
    		if (binarySearch(nums1, nums2[i], 0, nums1.length)) list.add(nums2[i]);
    	}

    	int[] arr = new int[list.size()];
		for(int i=0; i<arr.length; i++) arr[i] = list.get(i);
		return arr;
    }

    private static boolean binarySearch(int[] arr, int key, int low, int high) {
    	while(low <= high) {
    		int mid = low + (high - low) / 2;

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
    */


    public static void main(String[] args) {
    	int[] nums1 = {4,9,5};
    	int[] nums2 = {9,4,9,8,4};
    	int[] res = intersect3(nums1, nums2);
    	for(int i: res) System.out.print(i + " ");
    }
}