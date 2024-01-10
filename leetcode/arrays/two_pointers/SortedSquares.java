/*
977. Squares of a Sorted Array
Easy
Topics
Companies
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/

class SortedSquares {
	// Close observation of input
	//		Largest square will either be most positive (last number)
	//			or most negative (first number) in sorted array
	// 		Accordingly, use two pointers from 2 ends, to check
	//			which of the two gives max square.
	// Time;O(n) Space:O(1) Excluding return array
    private static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] arr = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--) {
        	if (Math.abs(nums[left]) > Math.abs(nums[right])) {
        		arr[i] = nums[left] * nums[left];
        		left++;
        	} else {
        		arr[i] = nums[right] * nums[right];
        		right--;
        	}
        }
        return arr;
    }

    public static void main(String[] args) {
    	int[] nums = {-4,-1,0,3,10};
    	int[] arr = sortedSquares(nums);
    	for (int i:arr)  System.out.print(i + " ");
    }
}