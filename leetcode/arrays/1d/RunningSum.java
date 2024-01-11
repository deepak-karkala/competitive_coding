/*
1480. Running Sum of 1d Array
Easy
Topics
Companies
Hint
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.
*/

class RunningSum {
	// Array 1D
    private static int[] runningSum(int[] arr) {
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
        	if (i == 0) res[i] = arr[i];
        	else res[i] = res[i-1] + arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] arr = {3,1,2,10,1};
    	int[] res = runningSum(arr);
    	for(int i: res) System.out.print(i + " ");
    }
}