/*
435. Non-overlapping Intervals
Medium
7.3K
190
Companies
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest
of the intervals non-overlapping.
*/
import java.util.*;

class NonoverlappingIntervals {
    private static int eraseOverlapIntervals(int[][] intervals) {
    	// Sort by end times of intervals
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int prev_end = Integer.MIN_VALUE;
        for(int i=0; i<intervals.length; i++) {
        	int curr_start = intervals[i][0];
        	if (curr_start >= prev_end) {
        		prev_end = intervals[i][1];
        		count++;
        	} 
        }

        return intervals.length - count;
    }

	public static void main(String[] args) {
    	int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3} };
    	int num = eraseOverlapIntervals(intervals);
    	System.out.println(num);
    }
}
