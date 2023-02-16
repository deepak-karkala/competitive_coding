/*
239. Sliding Window Maximum
Hard
13.6K
443

You are given an array of integers nums, there is a sliding window of size k
which is moving from the very left of the array to the very right. You can
only see the k numbers in the window. Each time the sliding window moves right
by one position.

Return the max sliding window.
*/
import java.util.*;

public class SlidingWindowMax {
	public static int[] slidingWindowMax(int[] nums, int k){
		Deque<Integer> q = new ArrayDeque<>();
		int[] maxs = new int[nums.length-k+1];

		for(int i=0; i<nums.length; i++) {
			// Remove indices which are outside window bounds 
			// (left side elements as window slides to right)
			while(!q.isEmpty() && q.peek()<i-k+1) q.poll();

			// Remove all indices where elements are smaller than
			// current element being added.
			while(!q.isEmpty() && nums[i]>nums[q.peekLast()]) q.pollLast();

			// Add this index to queue
			q.offer(i);

			// Update max for window ending at this position
			if(i>=k-1) maxs[i-k+1] = nums[q.peek()];
		}
		return maxs;
	}

	public static void main(String[] args) {
		int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
		int[] maxs = slidingWindowMax(nums, 3);
		for(int max: maxs) System.out.print(max+" ");
	}
}