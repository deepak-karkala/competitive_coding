/*
334. Increasing Triplet Subsequence
Medium
Topics
Companies
Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false
*/

class IncreasingTriplet {
    private static boolean increasingTriplet(int[] nums) {
    	int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for(int n: nums) {
            if (n <= first) first = n;
            else if (n <= second) second = n;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
    	int[] nums = {2,1,5,0,4,6};
    	System.out.println(increasingTriplet(nums));
    }
}