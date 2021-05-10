package sorting_searching;

import java.util.Arrays;

/*
 * You are given two sorted arrays, A and B, where A has a large enough
 *  buffer at the end to hold B. Write a method to merge B into A in sorted order.
 */


public class SortedMerge {
	
	public static <T extends Comparable<T>> T[] sortedMerge(T[] A, T[] B, int lenA, int lenB) {
		int idxA = lenA - 1;
		int idxB = lenB - 1;
		int mergedIdx = A.length - 1;
		
		while (idxB >= 0) {
			if (idxA >= 0 && A[idxA].compareTo(B[idxB]) >= 0) {
				A[mergedIdx--] = A[idxA--];
			} else {
				A[mergedIdx--] = B[idxB--];
			}
		}
		
		return A;
	}
	
	public static void main(String[] args) {
		int intMax = Integer.MAX_VALUE;
		Integer[] arrayA = {1, 8, 9, intMax, intMax, intMax, intMax};
		Integer[] arrayB = {2, 3, 5, 9};
		
		Integer[] sortedArray = sortedMerge(arrayA, arrayB, 3, 4);
		System.out.println(Arrays.toString(sortedArray));
	}
}