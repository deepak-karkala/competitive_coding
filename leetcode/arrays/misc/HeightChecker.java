/*
1051. Height Checker
Solved
Easy
Topics
Companies
Hint
A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.

You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).

Return the number of indices where heights[i] != expected[i].
*/

import java.util.*;

class HeightChecker {
    private static int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int count = 0;
        for(int i=0; i<heights.length; i++) {
            if (heights[i] != sorted[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,4,2,1,3};
    	System.out.println(heightChecker(nums));
    }
}