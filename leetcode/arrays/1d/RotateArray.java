/*
189. Rotate Array
Medium
Topics
Companies
Hint
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
*/

class RotateArray {
    private static int[] rotate2(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        	arr[(i + k) % nums.length] = nums[i];
        return arr;
    }

    private static int[] rotate(int[] nums, int k) {
    	k = k % nums.length;
    	if (k < 0) k += nums.length;

    	reverse(nums, 0, nums.length - k -1);
    	reverse(nums, nums.length - k, nums.length - 1);
    	reverse(nums, 0, nums.length - 1);

    	return nums;
    }

    private static void reverse(int[] nums, int left, int right){
    	while(left < right) {
    		int tmp = nums[right];
    		nums[right] = nums[left];
    		nums[left] = tmp;
    		left++;
    		right--;
    	}
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7};
    	int k = 3;
    	int[] arr = rotate(nums, k);
    	for(int i: arr) System.out.print(i + " ");
    }
}