/*
215. Kth Largest Element in an Array
Medium
Topics
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
*/
import java.util.*;

class KthLargest {
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int n: nums) pq.offer(n);

        int kthLargest = 0;
        for(int i=1; i<=k; i++)
        	kthLargest = pq.poll();

        return kthLargest;
    }

    public static void main(String[] args) {
    	int[] nums = {3,2,3,1,2,4,5,5,6};
    	int k = 4;
    	System.out.println(findKthLargest(nums, k));
    }
}