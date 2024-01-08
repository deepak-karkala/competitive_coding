/*
724. Find Pivot Index
Easy
Topics
Companies
Hint
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.
*/

class PivotIndex {
	// Array
	//	Compute leftsum, rightsum, see if it matches
    private static int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length + 1];
        int[] sumRight = new int[nums.length + 1];

        for(int i=0; i<nums.length; i++) {
        	sumLeft[i+1] = sumLeft[i] + nums[i];
        }

        for(int i=nums.length; i>=0; i--) {
        	if (i==nums.length) sumRight[i] = 0;
        	else sumRight[i] = sumRight[i+1] + nums[i];
        }

        for(int i=0; i<nums.length; i++) {
        	System.out.println(i + " " + sumLeft[i] + " " + sumRight[i+1]);
        	if (sumLeft[i] == sumRight[i+1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
    	int[] nums = {1,7,3,6,5,6};
    	System.out.println(pivotIndex(nums));
    }
}