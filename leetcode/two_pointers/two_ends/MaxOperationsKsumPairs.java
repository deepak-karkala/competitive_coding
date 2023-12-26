/*
1679. Max Number of K-Sum Pairs
Medium
Topics
Companies
Hint
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array
*/

import java.util.*;

class MaxOperationsKsumPairs {
    /*
    Approach: Brute force
    1. 2 pointers (i -> 0 to n, j->i+1 to n)
    Time: O(n^2) Space: O(1)
    */

    /*
    Approach: Sort and 2 pointers from two ends
    Time: O(nlogn) Space: O(1)
    */
    private static int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        int count = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if (sum == k) {
                count++;
                start++;
                end--;
            } else if (sum > k) end--;
            else start++;
        }
        return count;
    }


    /*
    Approach: Two sum (prefix sum)
    Time: O(n) Space: O(n)
    */
    private static int maxOperations2(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int rem = k - nums[i];

            if (map.containsKey(rem)) {
                count++;
                map.put(rem, map.get(rem) - 1);
                if (map.get(rem) == 0) map.remove(rem);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,3};
        int k = 6;
        System.out.println(maxOperations2(nums, k));
    }
}