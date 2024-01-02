/*
795. Number of Subarrays with Bounded Maximum
Medium
Topics
Companies
Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

The test cases are generated so that the answer will fit in a 32-bit integer.
*/


class NumSubarrayBoundedMax {
    private static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int end = 0, start = 0, count = 0, currMax = Integer.MIN_VALUE;

        while(end < nums.length) {
        	currMax = Math.max(currMax, nums[end]);

        	System.out.println(end + " " + nums[end] + " " + currMax + " " + count);


        	if (currMax >= left && currMax <= right) {
        		count++;
        		end++;
        	}


        	while (currMax > right) {
        		start++;
        	}
        }

        while(start < nums.length) {

        	if (currMax >= left && currMax <= right) count++;
        	start++;
        }

        return count;
    }

    public static void main(String[] args) {
    	int[] nums = {2,9,2,5,6};
    	int left = 2, right = 8;
    	System.out.println(numSubarrayBoundedMax(nums, left, right));
    }
}