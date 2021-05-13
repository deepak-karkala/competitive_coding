package sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find Duplicates: You have an array with all the numbers from 1 to N, 
 * where N is at most 32,000. The array may have duplicate entries and 
 * you do not know what N is. With only 4 kilobytes of memory available, 
 * how would you print all duplicate elements in the array?
 */


class BitSet {
	int[] bitset;
	
	public BitSet(int N) {
		bitset = new int[N];
	}
	
	// Set bit 
	public void set(int num) {
		int intIndex = num >> 5; // int(num/32)
		int bitPos = num & (0x1F); // num%32 = num & (31)
		
		bitset[intIndex] |= (1 << bitPos);
	}
	
	// Get bit
	public boolean get(int num) {
		int intIndex = num >> 5;
		int bitPos = num & 0x1F;
		
		return (bitset[intIndex] & (1 << bitPos)) != 0;
	}
	
}

public class FindDuplicates {
	
	public static void findDuplicates(int[] array) {
		List<Integer> duplicates = new ArrayList<Integer>();
		BitSet bs = new BitSet(32000);
		// Iterate through array
		// If repeated number (bitset.get(number) is true), add to duplicates
		// Else bitset.set(number) (Set bit to 1)
		for (int num: array) {
			if (bs.get(num)) {
				System.out.println(num);
				duplicates.add(num);
			} else {
				bs.set(num);
			}
		}
		System.out.println(duplicates);
	}
	
	
	public static void main(String[] args) {
		// N = 10
		int[] array = {4, 2, 1, 5, 1, 3, 3, 8, 9, 10, 7, 6, 4};
		findDuplicates(array);
	}
}