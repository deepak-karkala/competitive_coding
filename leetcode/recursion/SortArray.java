/*
912. Sort an Array
Medium
Topics
Companies
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time
complexity and with the smallest space complexity possible
*/

import java.util.*;

class SortArray {
	/* Merge Sort Recursive Top Down
	Time: O(n*logn) Space:O(n)
	*/
    private static int[] sortArrayMergeSort(int[] nums) {
    	if (nums.length <= 1) return nums;
    	int mid = nums.length / 2;

    	int[] leftSorted = sortArrayMergeSort(Arrays.copyOfRange(nums, 0, mid));
    	int[] rightSorted = sortArrayMergeSort(Arrays.copyOfRange(nums, mid, nums.length));

    	return merge(leftSorted, rightSorted);
    }

    private static int[] merge(int[] left, int[] right) {
    	int leftPtr = 0;
    	int rightPtr = 0;
    	int ptr = 0;
    	int[] merged = new int[left.length + right.length];

    	while(leftPtr < left.length && rightPtr < right.length) {
    		if (left[leftPtr] <= right[rightPtr]) {
    			merged[ptr++] = left[leftPtr++];
    		} else {
    			merged[ptr++] = right[rightPtr++];
    		}
    	}

    	while(leftPtr < left.length) merged[ptr++] = left[leftPtr++];
    	while(rightPtr < right.length) merged[ptr++] = right[rightPtr++];
    	return merged;
    }


    /* Incomplete - Merge Sort bottom up*/
    private static int[] sortArrayMergeSortBottomUp(int[] nums) {
    	for(int size=1; size<nums.length; size*=2){
    		for(int i=0; i<nums.length-size; i+=size*2) {
    			int start = i;
    			int mid = i + size - 1;
    			int end = Math.min(i + size*2 - 1, nums.length-1);
    			
    			int[] left = Arrays.copyOfRange(nums, start, mid+1);
    			int[] right = Arrays.copyOfRange(nums, mid+1, end);
    			int[] merged = merge(left, right);
    			
    			System.out.println(start + "-" + mid + "-" + end + "---" + left.length + "-" + right.length + "-" + merged.length);

    			System.arraycopy(merged, 0, nums, start, end);
    		}
    	}
    	return nums;
    }


    public static void main(String[] args) {
    	int[] nums = {5,1,1,2,0,0};
    	int[] sorted = sortArrayMergeSortBottomUp(nums);
    	for(int i: sorted) System.out.print(i + " ");
    }
}