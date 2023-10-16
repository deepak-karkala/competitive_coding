/*
2044. Count Number of Maximum Bitwise-OR Subsets
Medium
Topics
Companies
Hint
Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and
return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some
(possibly zero) elements of b. Two subsets are considered different if the indices of the
elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed)
*/
import java.util.*;

class CountMaxOrSubsets {
	/*
	Approach: Backtracking
	1. The max bitwise OR = OR of subset with all elements
	2. Generate all subsets
	3. Add subset to final result if its bitwise OR = max bitwise OR
	*/
    private static int countMaxOrSubsets(int[] nums) {
        int numSubsetsMaxOR = 0;
        // The max bitwise OR = OR of subset with all elements
        int maxOR = 0;
        for(int num: nums) maxOR = maxOR | num;
        numSubsetsMaxOR = backtrack(numSubsetsMaxOR, 0, nums, 0, maxOR);

        // Return the number of subsets with max bitwise OR
        return numSubsetsMaxOR;
    }

    private static int backtrack(int numSubsetsMaxOR, int currOR, int[] nums, int start, int maxOR) {
    	// Add current subset to final result if current bitwise OR == max bitwise OR
    	if (currOR == maxOR) {
    		numSubsetsMaxOR++; //lists.add(new ArrayList<>(list)); 
    	}

    	for(int i=start; i<nums.length; i++) {
    		numSubsetsMaxOR = backtrack(numSubsetsMaxOR, currOR | nums[i], nums, i+1, maxOR);
    	}
    	return numSubsetsMaxOR;
    }

    public static void main(String[] args) {
    	int[] nums = {3,2,1,5};
    	System.out.println(countMaxOrSubsets(nums));
    }
}