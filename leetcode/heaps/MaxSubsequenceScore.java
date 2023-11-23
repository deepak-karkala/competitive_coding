/*
2542. Maximum Subsequence Score
Medium
Topics
Companies
Hint
You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements
*/
import java.util.*;

class MaxSubsequenceScore {
	/*
		Priority Queue
		1. Create all pairs (nums1[i], nums2[i])
		2. Sort this in descending order of nums2.
		3. Maintain a PQ of length k
		4. Keep adding nums1[i] in the order of sorted pairs
				(in the order of nums2)
		5. When pq.size ==k, update maxScore
		6. If pq.size > k, remove pq.poll
				(this corresponds to lowest nums1[i] currently in PQ)
	*/
    private static long maxScore(int[] nums1, int[] nums2, int k) {
        long maxScore = 0, currSum = 0;

        int[][] pairs = new int[nums1.length][2];
        for(int i=0; i<nums1.length; i++) pairs[i] = new int[] {nums2[i], nums1[i]};
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] pair: pairs) {
        	pq.offer(pair[1]);		// Add nums1[i]
        	currSum += pair[1];

        	// Remove smallest nums1[i] in PQ when size > k
        	if (pq.size() > k) currSum -= pq.poll();	

        	// Update maxScore when size == k
        	// pair[0] will be current min(nums2[i] in PQ) since pairs are
        	//		added in descending order of nums2
        	if (pq.size() == k) maxScore = Math.max(maxScore, currSum * pair[0]);
        }
        return maxScore;
    }

    public static void main(String[] args) {
    	int[] nums1 = {1,3,3,2}, nums2 = {2,1,3,4};
    	int k = 3;

    	System.out.println(maxScore(nums1, nums2, k));
    }
}