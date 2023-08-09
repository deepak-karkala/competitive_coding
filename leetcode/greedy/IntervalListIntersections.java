/*
986. Interval List Intersections
Medium
5.2K
102
Companies
You are given two lists of closed intervals, firstList and secondList, 
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either
empty or represented as a closed interval. For example, the intersection of 
[1, 3] and [2, 4] is [2, 3].
*/
import java.util.*;

class IntervalListIntersections {

	private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int[][] intersection = new int[0][0];
		//ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		List<int []> list = new ArrayList<int []>();

		// check for empty lists
		if (firstList.length==0 || secondList.length==0) {
			return intersection;
		}

		// Iterate until we reach end of one of the lists
		int i=0, j=0;
		while(i<firstList.length && j<secondList.length) {

			// If second list's end is before first list's start, increment second
			if (secondList[j][1] < firstList[i][0]) {
				j++;
			} else if (firstList[i][1] < secondList[j][0]) { 
				//If first list's end is before second list's start, increment first
				i++;
			} else {
				// Start of intersection = max(start_first, start_second)
				// End of intersection = min(end_first, end_second)
				int start = Math.max(firstList[i][0], secondList[j][0]);
				int end = Math.min(firstList[i][1], secondList[j][1]);
				list.add(new int[]{start, end});
				//List<Integer> sublist = new ArrayList<Integer>();
				//sublist.add(start);
				//sublist.add(end);
				//list.add(new ArrayList<>(sublist));

				if (firstList[i][1] > secondList[j][1]) {
					j++;
				} else {
					i++;
				}

			}
		}

		/*
		intersection = new int[list.size()][2];
		for(int k=0; k<list.size(); k++) {
			intersection[k][0] = list.get(k).get(0);
			intersection[k][1] = list.get(k).get(1);
		}
		return intersection;
		*/
		return list.toArray(new int[list.size()][2]);
	}

	public static void main(String[] args) {
		int[][] firstList = { {0,2}, {5,10}, {13,23}, {24,25} };
		int[][] secondList = { {1,5}, {8,12}, {15,24}, {25,26} };
		int[][] intersection = intervalIntersection(firstList, secondList);
		
		for(int i=0; i<intersection.length; i++) {
			System.out.println(intersection[i][0] + " " +  intersection[i][1]);
		}
	}

}