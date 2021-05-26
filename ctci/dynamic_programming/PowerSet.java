package dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * Write a method to return all subsets of a set.
 */

public class PowerSet {
	
	/*
	 * Solution 1:
	 * Recursion (Base case and build)
	 * 1. Given all subsets of first n-1 elements, 
	 * 		Generate all subsets of first n elements
	 * 2. n = 0 => {}
	 * 3. n = 1 => {}, {a}
	 * 4. n = 2 => {}, {a}, {b}, {a,b}
	 * 5. n = 3 => {}, {a}, {b}, {a,b}, {c}, {a,c}, {b,c}, {a,b,c}
	 * 5. For each subset of first n-1 elements
	 * 		Append nth element
	 * 6. Recursion n -> n-1 -> n-2 -> ... -> 0
	 */
	public static ArrayList<ArrayList<String>> findSubsets1(String[] set) {
		ArrayList<ArrayList<String>> allSubsets = new ArrayList<ArrayList<String>>();
		findSubsets1(set, set.length, allSubsets);
		return allSubsets;
	}
	
	public static void findSubsets1(String[] set, int len,
			ArrayList<ArrayList<String>> allSubsets) {
		ArrayList<ArrayList<String>> moreSubsets = new ArrayList<ArrayList<String>>();

		// Base case
		if (len == 0) {
			ArrayList<String> emptySet = new ArrayList<String>();
			moreSubsets.add(emptySet);
		} else {
			
			// Recursive call
			findSubsets1(set, len-1, allSubsets);
			
			
			// For each subset of first n-1 elements
			// 		Append nth element
			for(ArrayList<String> subset: allSubsets) {
				String s = set[len-1];
				
				ArrayList<String> newSubset = new ArrayList<String>();
				newSubset.addAll(subset);
				newSubset.add(s);
				moreSubsets.add(newSubset);
			}
		}
		allSubsets.addAll(moreSubsets);
		return;
	}
	
	
	/*
	 * Solution 2
	 * From all subsets of length n-1, generate all subsets of length n
	 * Use hashset to avoid repeating subsets
	 */
	public static HashSet<HashSet<String>> findSubsets2(String[] set) {
		HashSet<HashSet<String>> allSubsets = new HashSet<HashSet<String>>();
		findSubsets2(set, set.length, allSubsets);
		return allSubsets;
	} 
	
	public static void findSubsets2(String[] set, int len,
			HashSet<HashSet<String>> allSubsets) {
	
		HashSet<HashSet<String>> moreSubsets = new HashSet<HashSet<String>>();

		// Base case
		if (len == 0) {
			HashSet<String> emptySet = new HashSet<String>();
			moreSubsets.add(emptySet);
		} else {
			
			//Recursive call
			findSubsets2(set, len-1, allSubsets);
			
			//From all subsets of length n-1, generate all subsets of length n
			for(HashSet<String> hs: allSubsets) {
				for(String s: set) {
					HashSet<String> newSubset = new HashSet<String>();
					newSubset.addAll(hs);
					newSubset.add(s);
					moreSubsets.add(newSubset);
				}
			}
		}
		allSubsets.addAll(moreSubsets);
	}
	
	
	/*
	 * Solution 3: Combinatorics
		Generate all numbers from 1 to 2^n 
		Get binary representation (000, 001, 010, 011, 100, 101… 111)
		For each number, add those elements in the set which has 1 in its index position.
	 */
	public static ArrayList<ArrayList<String>> findSubsets3(String[] set) {
		ArrayList<ArrayList<String>> allSubsets = new ArrayList<ArrayList<String>>();
		
		int numSubsets = 1 << set.length;
		for (int i=0; i < numSubsets; i++) {
			ArrayList<String> subset = convertIntToSet(set, i);
			allSubsets.add(subset);
		}
		
		return allSubsets;
	} 
	
	public static ArrayList<String> convertIntToSet(String[] set, int num) {
		ArrayList<String> subset = new ArrayList<String>();
		
		int index = 0;
		for (int i = num; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				subset.add(set[index]);
			}
			index++;
		}
		return subset;
	}
	
	
	public static void main(String[] args) {
		String[] set = {"a", "b", "c", "d"};
		HashSet<HashSet<String>> subsets = findSubsets2(set);	
		System.out.println(Arrays.toString(subsets.toArray()));	
 	}
}