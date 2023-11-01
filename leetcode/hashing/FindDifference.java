/*
2215. Find the Difference of Two Arrays
Easy
Topics
Companies
Hint
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.
*/

import java.util.*;

class FindDifference {
	/*
		Using hashset
		Time: O(len(nums1) + len(nums2)) Space: O(max(len(nums1), len(nums2)))
	*/
    private static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        HashSet<Integer> hset1 = new HashSet<Integer>();
        HashSet<Integer> hset2 = new HashSet<Integer>();

        for(int n1: nums1) hset1.add(n1);
        for(int n2: nums2) hset2.add(n2);

        lists.add(new ArrayList<>());
        lists.add(new ArrayList<>());
        for(int i: hset1) if (!hset2.contains(i)) lists.get(0).add(i);
        for(int i: hset2) if (!hset1.contains(i)) lists.get(1).add(i);
        
        return lists;
    }

    public static void main(String[] args) {
    	int[] nums1 = {1,2,3}, nums2 = {2,4,6};
    	List<List<Integer>> lists = findDifference(nums1, nums2);
    	for(List<Integer> list: lists)
    		System.out.print(list + " ");
    }
}