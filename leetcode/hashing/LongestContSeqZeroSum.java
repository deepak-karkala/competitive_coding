/*
LC - Premium
Largest Continuous Sequence Zero Sum
Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.
*/

import java.util.*;

public class LongestContSeqZeroSum {
	/*
	Hint
		Lets try to reduce the problem to a much simpler problem. 
			Lets say we have another array sum where sum[i] = Sum of all elements from A[0] to A[i]
		Note that in this array, sum of elements from A[i] to A[j] = Sum[j] - Sum[i-1]
		We need to find j and i such that sum of elements from A[i] to A[j] = 0 Or 
			Sum[j] - Sum[i-1] = 0  Or Sum[j] = Sum[i-1]
		Now, the problem reduces to finding 2 indices i and j such that sum[i] = sum[j]
			How can you solve the above problem ?
	After hint
		Iterate through array, find sum till i-th element stored in sum[]: O(n)
		To find two indices where sum[i] = sum[j],
		Use hashing like in 2sum => O(n)
		Record diff in indices, j-i if better than current result
		=> O(n)
	*/
    private static int[] longestContSeqZeroSum(int[] nums) {
    	if (nums.length == 0) return Arrays.copyOfRange(nums, 0, 0); //arrayListToIntArray(new ArrayList<Integer>());

    	// Find sum[] where sum[i] = sum of elements from nums[0...i]
    	int[] sum = new int[nums.length];
    	sum[0] = nums[0];
    	for(int i=1; i<nums.length; i++){
    		sum[i] = sum[i-1] + nums[i];
    	}

    	// Find two indices start, end such that sum[start] = sum[end]
    	int start=0, end=0, currLen=0, maxLen=0, bestStart=0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0; i<nums.length; i++){

    		if (sum[i]==0 || map.containsKey(sum[i])) {
    			start = sum[i]==0 ? 0 : map.get(sum[i]) + 1;
    			end = i;
    			currLen = end-start+1;
    			if (currLen > maxLen) {
    				maxLen = currLen;
    				bestStart = start;
				}
    		} else {
	    		map.put(sum[i], i);
	    	}
    	}


    	int[] res = Arrays.copyOfRange(nums, bestStart, bestStart+maxLen);
    	return res;
    }

    private static int[] arrayListToIntArray(List<Integer> list) {
    	int[] arr = new int[list.size()];
    	for(int i=0; i<list.size(); i++) {
    		arr[i] = list.get(i);
    	}
    	return arr;
    }

    public static void main(String[] args) {
    	int[] nums = {1, 2, -3, 3};
    	int[] res = longestContSeqZeroSum(nums);
    	for(int i=0; i<res.length; i++) {
    		System.out.print(res[i] + " ");
    	}
    }
}