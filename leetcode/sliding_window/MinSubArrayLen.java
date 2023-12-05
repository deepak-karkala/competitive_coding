/*
209. Minimum Size Subarray Sum
Medium
Topics
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

class MinSubArrayLen {
	/*
	Approach: Sliding window with two pointers template
	Time: O(n) Space: O(1)
	*/
    private static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        int currSum = 0;

        while(end < nums.length) {
        	currSum += nums[end];
        	end++;

        	while (currSum >= target) {
        		minLen = Math.min(minLen, end - start);
        		currSum -= nums[start];
        		start++;
        	}
        }
        return minLen == Integer.MAX_VALUE ? 0 : Math.min(minLen, end-start+1); 
    }

    /*
	Approach: Binary Search
		1. Store accumulated sum till i
		2. For each index with sum[i], search for sum[j]-s, for j=0toi-1
				or sum[i], search for sum[j]+s, for j=i+1toend
		3. Binary search will return index, update minLen based on it
	Time: O(nlogn) Space: O(n)
	*/
    private static int minSubArrayLenBinarySearch(int target, int[] nums) {
    	int[] sums = new int[nums.length + 1];
    	for(int i=1; i<sums.length; i++) sums[i] = sums[i-1] + nums[i-1];
    	int minLen = Integer.MAX_VALUE;

    	for(int i=0; i<nums.length; i++) {
    		int end = binarySearch(i+1, sums.length-1, sums[i]+target, sums);
    		if (end == sums.length) break;
    		minLen = Math.min(minLen, end - i);
    	}

    	return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private static int binarySearch(int low, int high, int key, int[] nums) {
    	while(low <= high) {
	    	int mid = low + (high - low) / 2;
    		if (nums[mid] >= key) {
    			high = mid - 1;
    		} else {
    			low = mid + 1;
    		}
    	}

    	return low;
    }


    public static void main(String[] args) {
    	int target = 7;
    	int[] nums = {2,3,1,2,4,3};
    	System.out.println(minSubArrayLenBinarySearch(target, nums));
    }
}