/*
414. Third Maximum Number
Easy
Topics
Companies
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
*/
import java.util.*;

class ThirdMax {
	// Array, track top 3 maximums
    // Time; O(n) Space:O(1)
    private static int thirdMax(int[] nums) {
        Integer firstMax = null, secondMax = null, thirdMax = null;

        for(Integer n: nums) {
        	if (n.equals(firstMax) || n.equals(secondMax) || n.equals(thirdMax)) continue;

        	// Current number greater than first max
        	if (firstMax == null || n > firstMax) {
        		thirdMax = secondMax;
        		secondMax = firstMax;
        		firstMax = n;
        	} else if (secondMax == null || n > secondMax && n < firstMax) {
        		thirdMax = secondMax;
        		secondMax = n;
        	} else if (thirdMax == null || n > thirdMax && n < secondMax) {
        		thirdMax = n;
        	}
        }

        return thirdMax == null ? firstMax : thirdMax;
    }

    // PQ + Set
    // Time; O(n) Space:O(1)
    private static int thirdMax2(int[] nums) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	Set<Integer> set = new HashSet<>();

    	for(int n: nums) {
    		if (!set.contains(n)) {
    			set.add(n);
    			pq.offer(n);

    			// Remove least element if PQ size > 3
    			if (pq.size() > 3) set.remove(pq.poll());
    		}
    	}

    	// If pq.size<3, return largest element
    	if (pq.size() < 3) {
    		while(pq.size() > 1) pq.poll();
    	}
    	return pq.peek();
    }

    public static void main(String[] args) {
    	int[] nums = {3,2,1};
    	System.out.println(thirdMax2(nums));
    }
}