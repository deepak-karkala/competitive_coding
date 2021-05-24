package dynamic_programming;

/*
 * A magic index in an array A[ 1.•.n-1] is defined to be an 
 * index such that A[ i]
 i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
	FOLLOW UP
	What if the values are not distinct?
*/

public class MagicIndex {
	
	
	public static int findMagicIndex(int[] array) {
		return findMagicIndex(array, 0, array.length-1);
	}
	
	public static int findMagicIndex(int[] array, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) >>> 1;

		if (array[mid] == mid) {
			return mid;
		} else if (array[mid] > mid) {
			return findMagicIndex(array, low, mid-1);
		} else {
			return findMagicIndex(array, mid+1, high);
		}
	}
	
	
	public static void main(String[] args) {
		int[] sortedArray = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
		System.out.println(findMagicIndex(sortedArray));
	}
}

