/*
Given a set of N intervals denoted by 2D array A of size N x 2, the task is to
find the length of maximal set of mutually disjoint intervals.
Two intervals [x, y] & [p, q] are said to be disjoint if they do not have any point in common.
Return a integer denoting the length of maximal set of mutually disjoint intervals.
*/

import java.util.*;

class DisjointIntervals {

	private static int disjointIntervals(ArrayList<ArrayList<Integer>> A) {
		A.sort(Comparator.comparingInt(o -> o.get(1)));

		int i=0;
		int count = 0;
		int prev_end = Integer.MIN_VALUE;
		
		while(i < A.size()) {
			int curr_start = A.get(i).get(0);
			if (curr_start > prev_end) {
				count++;
				prev_end = A.get(i).get(1);
			}
			i++;
		}
        return count;
	}


	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1); list.add(4); A.add(new ArrayList<>(list)); list.clear();
		list.add(2); list.add(3); A.add(new ArrayList<>(list)); list.clear();
		list.add(4); list.add(6); A.add(new ArrayList<>(list)); list.clear();
		list.add(8); list.add(9); A.add(new ArrayList<>(list)); list.clear();

		int len = disjointIntervals(A);
		System.out.println(len);
	}

}