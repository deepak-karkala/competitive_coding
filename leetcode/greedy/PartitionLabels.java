/*
763. Partition Labels
Medium
9.8K
358
Companies
You are given a string s. We want to partition the string into as many parts as
possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order,
the resultant string should be s.

Return a list of integers representing the size of these parts.
*/

import java.util.*;

class PartitionLabels {
	// Approach: Solve on paper, find algo, code it
	// Time: O(n) Space: O(1)
    private static List<Integer> partitionLabels(String s) {
        //Store the last occurrence of each character in string
        int[] last = new int[26];	// Assuming only lowercase characters
        for(int i=0; i<s.length(); i++) {
        	last[s.charAt(i)-'a'] = i;
        }

        // Iterate through and find splits greedily
        int curr_list_max = 0;
        int prev_list_end = -1;
        List<Integer> splits = new ArrayList<Integer>();

        for(int i=0; i<s.length(); i++) {
        	curr_list_max = Math.max(curr_list_max, last[s.charAt(i)-'a']);
        	// Create a new list if i==curr_list_max
        	if (i == curr_list_max) {
        		splits.add(curr_list_max - prev_list_end);
        		prev_list_end = curr_list_max;
        	}
        }
        return splits;
    }

    public static void main(String[] args) {
    	String s = "ababcbacadefegdehijhklij";
    	List<Integer> list = partitionLabels(s);
    	System.out.println(list);
    }
}