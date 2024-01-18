/*
2090. K Radius Subarray Averages
Medium
Topics
Companies
Hint
You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k is the average of all elements in nums between the indices i - k and i + k (inclusive). If there are less than k elements before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i] is the k-radius average for the subarray centered at index i.
*/
import java.util.*;

class KRadiusAverages {
    private static int[] getAverages(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (i < k) res[i] = -1;            
            sum += nums[i];
            if (i >= 2*k) {
                res[i - k] = (int)(sum / (2*k + 1));
                sum -= nums[i - 2*k];
            }
			if (i >= N - k) res[i] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {7,4,3,9,1,8,5,2,6};
    	int k = 3; //100000;
    	int[] arr = getAverages(nums, k);
    	for(int i: arr) System.out.println(i + " ");
    }
}