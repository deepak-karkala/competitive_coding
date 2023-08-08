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
	private static int majorityElement_hashmap(int[] nums) {
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

    // Sorting
    // Time: O(nlogn) Space: O(1)
	private static int majorityElement_sorting(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	// Moore voting
	// Given: majority element occurs >len/2 number of times
	// Keep incrementing if majoirty element and decrementing if not
	// If count =0 it implies potential for new majority element
	// Time: O(n) Space: O(1)
	private static int majorityElement_voting(int[] nums) {
		int me = nums[0], count = 0;

		for(int num: nums) {
			if (count == 0) {
				me = num;
				count++;
			} else if (num == me) {
				count++;
			} else {
				count--;
			}
		}
		return me;
	}

	// Bit manipulation
	// Given majority element is present more than len/2 times
	// => Bit representation of majority element will have number of times 
	// bits set in those position greater than len/2 times
	// => Count number of times each bit (in total 32 bits) gets set as you iterate through the array
	// Time: O(n) Space: O(1)
	private static int majorityElement_bit(int[] nums) {
		int[] bits = new int[32];

		// Count number of times bit is set at each position
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<32; j++) {
				bits[j] += (nums[i]>>j) & 1;
			}
		}

		int me = 0;
		// Determine which bits are set more than len/2 number of times
		for(int j=0; j<32; j++) {
			bits[j] = bits[j] > nums.length/2 ? 1 : 0;
			me += bits[j] << j;
		}
		return me;
	}

	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int me = majorityElement_bit(nums);
		System.out.println(me);
	}
}