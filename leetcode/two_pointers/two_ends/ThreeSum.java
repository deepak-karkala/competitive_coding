/*
15. 3Sum
Medium
Topics
Companies
Hint
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
*/
import java.util.*;

class ThreeSum {
	/*
	Approach: 2 pointers from two ends
		1. Two Sum solution
			Not possible if indices are asked (have to use prefix sum in this case, Time:O(n) Space:O(n)),
			but if values are asked then I can sort the array, use two pointer 
				from two ends (Time:O(n) Space:O(1)).
		2. In this case, values are asked, not indices, which means two pointers from two ends can be used
		3. Fix one integer, then do two sum for rest of array
		4. Use Set<List> to ensure that duplicate triplets are avoided
	Time: O(n*n) Space:O(1)
	*/
    private static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> lists = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length - 2; i++) {
        	int j = i + 1;
        	int k = nums.length - 1;

        	while(j < k) {
        		int val = nums[i] + nums[j] + nums[k];

        		if (val == 0) lists.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
        		else if (val > 0) k--;
        		else if (val < 0) j++;
        	}
        }
        return new ArrayList<>(lists);
    }

    public static void main(String[] args) {
    	int[] nums = {-1,0,1,2,-1,-4};
    	List<List<Integer>> lists = threeSum(nums);
    	for(List<Integer> list: lists) {
    		for(Integer i: list) System.out.print(i + " ");
	    	System.out.println("");
    	}
    }
}