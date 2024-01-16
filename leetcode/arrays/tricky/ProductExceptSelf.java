/*
238. Product of Array Except Self
Medium
Topics
Companies
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*/

import java.util.*;

class ProductExceptSelf {
	// Array: Prefix and suffix product
    private static int[] productExceptSelf(int[] nums) {
    	int[] prod = new int[nums.length];
    	Arrays.fill(prod, 1);

    	// Prefix product
    	int curr = 1;
    	for(int i=0; i<nums.length; i++) {
    		prod[i] *= curr;
    		curr *= nums[i];
    	}

    	// Suffix product
    	curr = 1;
    	for(int i=nums.length-1; i>=0; i--) {
    		prod[i] *= curr;
    		curr *= nums[i];
    	}
    	return prod;
    }

    public static void main(String[] args) {
    	int[] nums = {1, 2, 3, 4};
    	int[] prod = productExceptSelf(nums);
    	for(int i:prod) System.out.print(i + " ");
    }
}