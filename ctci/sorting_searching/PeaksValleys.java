package sorting_searching;

import java.util.Arrays;

/*
 * Peaks and Valleys: In an array of integers, a "peak" is an element 
 * which is greater than or equal to the adjacent integers and a "valley" 
 * is an element which is less than or equal to the adjacent integers. 
 * For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and 
 * {5, 2} are valleys. Given an array of integers, sort the array into 
 * an alternating sequence of peaks and valleys.
 */


public class PeaksValleys {
	
	public static int[] sortPeaksValleys(int[] array) {
		for(int i = 1; i < array.length - 1; i+=2) {
			int maxIndex = findMaxIndex(array, i-1, i, i+1);
			if (i != maxIndex)
				swap(array, i, maxIndex);
		}
		return array;
	}
	
	public static int findMaxIndex(int[] array, int i, int j, int k) {
		int maxIndex = -1;
		
		int maxValue = Math.max(array[i], Math.max(array[j], array[k]));
		
		if (array[i] == maxValue) return i;
		if (array[j] == maxValue) return j;
		if (array[k] == maxValue) return k;
		return maxIndex;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {9, 1, 0, 4, 8, 7};
		sortPeaksValleys(array);
		System.out.println(Arrays.toString(array));
	}
}