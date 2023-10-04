/*
967. Numbers With Same Consecutive Differences
Medium
Topics
Companies
Given two integers n and k, return an array of all the integers of length n where
the difference between every two consecutive digits is k. You may return the answer
in any order.

Note that the integers should not have leading zeros. Integers as 02 and 043 are
not allowed.
*/

import java.util.*;

class NumsSameConsecDiff {
	/*
	Approach: Backtracking for each digit from 1 to 9
	Time: O(10 * 2^n)
	*/
    private static int[] numsSameConsecDiff(int n, int k) {
    	List<Integer> list = new ArrayList<>();
        for(int d=1; d<=9; d++) {
        	backtrack(d, n-1, k, list);
        }

        /*
        int len = list.size();
        int[] arr = new int[len];
        for(int i=0; i<len; i++) {
        	arr[i] = list.get(i);
        }
        return arr;
        */
        return list.stream().mapToInt(i -> i).toArray();
    }

    private static void backtrack(int i, int n, int k, List<Integer> list) {
    	//if (i / Math.pow(10, n-1) >= 1) {
    	if (n == 0) {
    		if (!list.contains(i)) list.add(i);
    		return;
    	}

    	int lastdigit = i % 10;
    	if (lastdigit + k <= 9) {
    		backtrack(i*10 + (lastdigit+k), n-1, k, list);
    	}

    	if (lastdigit - k >= 0) {
    		backtrack(i*10 + (lastdigit-k), n-1, k, list);
    	}
    	return;
    }

    public static void main(String[] args) {
    	int n = 2, k = 1;
    	int[] arr = numsSameConsecDiff(n, k);
    	for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
    }
}