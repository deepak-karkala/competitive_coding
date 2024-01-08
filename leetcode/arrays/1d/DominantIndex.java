/*
747. Largest Number At Least Twice of Others
Easy
Topics
Companies
Hint
You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
*/

class DominantIndex {
	// Arrays: 1d
	//	Scan array, record max and maxIndex
	//	Iterate and see if every other element*2 is less than max
    private static int dominantIndex(int[] nums) {
    	int max = Integer.MIN_VALUE, maxIndex = -1;
        for(int i=0; i<nums.length; i++) {
        	if (nums[i] > max) {
        		max = nums[i];
        		maxIndex = i;
        	}
        }

        for(int i=0; i<nums.length; i++) {
        	if (i != maxIndex && nums[i]*2 > max) return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
    	int[] nums = {3,6,1,0};
    	System.out.println(dominantIndex(nums));
    }
}