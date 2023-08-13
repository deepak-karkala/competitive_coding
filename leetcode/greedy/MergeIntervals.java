/*
56. Merge Intervals
Medium
20.3K
686
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all
overlapping intervals, and return an array of the non-overlapping intervals
that cover all the intervals in the input.
*/

import java.util.*;

class MergeIntervals {
	// Approach: Two pointers, check all conditions
	// Time: O(n) Space:O(1)
    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<int[]>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int prev_start = intervals[0][0];
        int prev_end = intervals[0][1];
        list.add(0, new int[] {prev_start, prev_end});
        int j=1, k=0;

		while (j < intervals.length) {
        	int curr_start = intervals[j][0];
        	int curr_end = intervals[j][1];

        	if (curr_start >= prev_start && curr_start <= prev_end) {
        		prev_end = Math.max(prev_end, curr_end);
        		list.set(k, new int[]{prev_start, prev_end});
        	} else if (curr_start > prev_end) {
        		prev_start = curr_start;
        		prev_end = curr_end;
        		k++;
	        	list.add(k, new int[]{prev_start, prev_end});
        	}
        	j++;
        }

		return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
    	int[][] intervals = { {1,3}, {2,6}, {8,10}, {15,18} };
    	int[][] merged = mergeIntervals(intervals);
    	for(int i=0; i<merged.length; i++) {
    		System.out.println(merged[i][0] + " " + merged[i][1]);
    	}
    }
}