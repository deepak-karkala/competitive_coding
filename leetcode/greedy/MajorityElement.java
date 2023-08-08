/*
169. Majority Element
Easy
16.2K
466
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/


import java.util.*;

class MajorityElement {

	// Hashmap
	// Time: O(n) Space:O(n)
	private static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int me = 0;
		for(int num: nums) {
			/*
			if (!hm.containsKey(num)) {
				hm.put(num, 1);
			} else {
				hm.put(num, hm.get(num)+1);
			}
			*/
			hm.put(num,hm.getOrDefault(num,0)+1);

			if (hm.get(num) > nums.length/2) {
				me = num;
				break;
			}
		}
		return me;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int me = majorityElement(nums);
		System.out.println(me);
	}
}