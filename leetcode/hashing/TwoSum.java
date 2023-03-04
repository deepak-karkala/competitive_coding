/*
1. Two Sum
Easy
43.9K
1.4K
Companies
Given an array of integers nums and an integer target, return indices of the
two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may
not use the same element twice.

You can return the answer in any order.
*/
import java.util.*;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
            	res[0] = hm.get(target - nums[i]);
            	res[1] = i;
            	return res;
            } else {
            	hm.put(nums[i], i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {3,3};
    	int target = 6;
    	int[] res = twoSum(nums, target);
    	System.out.println(res[0] + "," + res[1]);
    }
}