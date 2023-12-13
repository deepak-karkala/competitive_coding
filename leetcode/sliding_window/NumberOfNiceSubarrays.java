/*
1248. Count Number of Nice Subarrays
Medium
Topics
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays
*/


class NumberOfNiceSubarrays {
	/*
	Approach: Sliding window
		1. Exactly(k odd) = AtMost(k odd) - AtMost(k-1 odd)
		2. AtMost(k odd) can be found using standard 2 pointers template
	*/
    private static int numberOfSubarrays(int[] nums, int k) {
        return atMostKOdd(nums, k) - atMostKOdd(nums, k-1);
    }

    private static int atMostKOdd(int[] nums, int k) {
    	int start = 0, count = 0, numKOdd = 0;

    	for(int end = 0; end < nums.length; end++) {
    		if (nums[end] % 2 == 1) numKOdd++;

    		while(numKOdd > k) {
    			if (nums[start] % 2 == 1) numKOdd--;
    			start++;
    		}

    		count += end-start+1;
    	}
    	return count;
    }

    public static void main(String[] args) {
    	int[] nums = {2,2,2,1,2,2,1,2,2,2};
    	int k = 2;
    	System.out.println(numberOfSubarrays(nums, k));
    }
}