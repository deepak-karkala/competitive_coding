/*
373. Find K Pairs with Smallest Sums
Medium
3.9K
230
Companies
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u, v) which consists of one element from the first array and one element from the second array.
Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
*/

import java.util.*;

public class KSmallestPairs {

	private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
		if (nums1.length==0 || nums2.length==0) return new ArrayList<List<Integer>>();

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] + a[1])));

		// Insert all elements of nums1 paired with nums2[0], the 3rd array element refers 
		// to index of current element being used in nums2
		for(int i=0; i<nums1.length && i<k; i++) q.offer(new int[]{nums1[i], nums2[0], 0});

		// Add the first pair, after which there are always two options,
		// to pick from (the one already added in queue) vs use the element
		// from next index in nums2 (add this pair to queue). Prirority queue
		// will then have this pair (smallest sum) in its poll, use it.
		while(k-- >0 && !q.isEmpty()) {
			int[] smallestPair = q.poll();
			List<Integer> pair = new ArrayList<Integer>();
			pair.add(smallestPair[0]);
			pair.add(smallestPair[1]);
			res.add(pair);

			// If there are still elements in nums2, add the element
			// at next index to queue.
			if (smallestPair[2] < nums2.length-1){
				int idx = smallestPair[2] + 1;
				q.offer(new int[]{smallestPair[0], nums2[idx], idx});
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3;
		System.out.println(kSmallestPairs(nums1, nums2, k));
	}
}