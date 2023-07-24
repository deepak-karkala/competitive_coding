/*
300. Longest Increasing Subsequence
Medium
17.3K
328
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
*/
import java.util.*;

class LongestIncreasingSubsequence {

	// Recursion - Time: O(2^N) Space: O(N)
    private static int lengthOfLIS_recursion(int[] nums) {
    	int maxLen = 0;
    	for(int i=0; i<nums.length; i++) {
    		maxLen = Math.max(maxLen, lengthOfLIS_endingAtI(nums, i));
    	}
    	return maxLen;
    }

    private static int lengthOfLIS_endingAtI(int[] nums, int i){
    	//Base case
    	if (i==0) return 1;

    	//Recursive call
    	int maxLenEndingAtI = 1;
    	for(int j=0; j<i; j++) {
    		if (nums[i] > nums[j]) {
    			maxLenEndingAtI = Math.max(maxLenEndingAtI, 1 + lengthOfLIS_endingAtI(nums, j));
    		}
    	}
    	return maxLenEndingAtI;
    }

    // DP: Bottom up Time: O(N^2) Space: O(N)
    private static int lengthOfLIS_dp_bottomup(int[] nums) {
    	// Bottom up
    	int[] maxLenEndingAtI = new int[nums.length];
    	for (int i=0; i<nums.length; i++) maxLenEndingAtI[i] = 1;

    	for(int i=1; i<nums.length; i++) {
    		for(int j=0; j<i; j++) {
    			if (nums[i] > nums[j]) maxLenEndingAtI[i] = Math.max(maxLenEndingAtI[i], 1 + maxLenEndingAtI[j]);
    		}
    	}

    	int maxLen = 0;
    	for(int i=0; i<nums.length; i++) {
    		maxLen = Math.max(maxLen, maxLenEndingAtI[i]);
    	}
    	return maxLen;
    }

    // Greedy with binary Search Time: O(N*logN) Space: O(N)
    private static int lengthOfLIS_greedy_binarysearch(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int tail = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            int curr = nums[i];

            // If current element > tail, append
            // else, replace smallest element greater than curr
            if (curr > tail) {
                list.add(curr);
            } else {
                int[] arr = list.stream().mapToInt(j -> j).toArray();
                int indexOfSmallestElementGreaterThanKey = binarysearch_greaterthan(arr, 0, list.size()-1, curr);
                list.set(indexOfSmallestElementGreaterThanKey, curr);
            }
            tail = list.get(list.size()-1);
            //for (int x: list) System.out.println(x);
            //System.out.println("---");
        }
        //for (int x: list) System.out.println(x);
        return list.size();
    }

    private static int binarysearch_greaterthan(int[] arr, int low, int high, int key) {
        int result = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > key) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        if (false) {
            System.out.println("***");
            for (int x: arr) System.out.println(x);
            System.out.println(key);
            System.out.println(result);
            System.out.println("***");
        }
        return result;
    }

    public static void main(String[] args) {
    	int[] arr = {10,9,2,5,3,7,101,18};
    	System.out.println(lengthOfLIS_greedy_binarysearch(arr));
    }
}
