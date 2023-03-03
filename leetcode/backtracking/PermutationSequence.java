/*
60. Permutation Sequence
Hard
5.4K
432
Companies
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
*/

import java.util.*;

public class PermutationSequence {
	/*
		Approach - Baseline - Generate all permutations, return kth => classic backtracking
		Challenge - to only generate kth permutation
		Approach
			1. At top level, there are total of n! permutations, kth permutation is asked
				=> (k-1) first permutations are to be ignored
			2. Number of subsets per branch = (n-depth-1)! 
			3. So the element to be picked = floor( numSubsetsToSkip / numSubsetsPerBranch)
			4. Update number of subsets to skip -= numSubsetsPerBranch * elementToBePicked
			5. Go on adding the elementToBePicked to final result, at each depth, keep track
				of the current options (elements which are yet to be chosen => those not there in
				result yet)
	*/
	private static String permutationSequence(int n, int k){
		int numSubsetsToSkip = k-1;

		List<Integer> currentElements = new ArrayList<Integer>();
		for(int i=0; i<n; i++) currentElements.add(i+1);

		List<Integer> result = new ArrayList<Integer>();

		for(int i=0; i<n; i++){
			// Update the current options (elements to choose from)
			for(int element: result) {
				currentElements.remove(Integer.valueOf(element));
			}

			// Number of subsets to skip
			int numSubsetsPerBranch = factorial(n-i-1);
			int elementToBePicked = (int) Math.floor(numSubsetsToSkip/numSubsetsPerBranch);
			numSubsetsToSkip -= numSubsetsPerBranch * elementToBePicked;

			// Add element to result
			result.add(currentElements.get(elementToBePicked));
		}
		
		StringBuilder sb = new StringBuilder(n);
		for(int i=0; i<n; i++) sb.append(""+result.get(i));
		return sb.toString();
	}

	private static int factorial(int n) {
		if(n<=1) return 1;
		if(n==2) return 2;
		return n*factorial(n-1);
	}

	public static void main(String[] args) {
		System.out.println(permutationSequence(3, 3));
	}
}