/*
Meeting rooms
Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.
Find the minimum number of conference rooms required so that all meetings can be done.
*/

import java.util.*;

class MeetingRooms {

	// O(n): Greedy - does not work
	private static int meetingRooms(ArrayList<ArrayList<Integer>> A) {
		A.sort(Comparator.comparingInt(o -> o.get(1)));
		System.out.println(A);

		int num=1;
		int prev_end = Integer.MIN_VALUE;
		int prev_meeting_id = -1;

		for(int i=0; i<A.size(); i++){
			int curr_start = A.get(i).get(0);
			if (curr_start >= prev_end) {
				prev_meeting_id += 1;
				prev_end = A.get(prev_meeting_id).get(1);
			} else {
				num++;
			}
		}

		return num;
	}

	/*
	Solution 1: Use min heap to store the meeting rooms end time. If new meeting 
	start time is greater or equal than least element, update it.
	If not, open a new meeting room. Report the min heap size at the end.
	Time Complexity : O(NlogN).

	Solution 2: Two sorted array of start time and end time. Two pointers to iterator
	start array and end array. Iterate the time line, the current time active meeting
	is num of start minus num of end. Since need sort, still O(nlogn) solution, 
	but fast than solution 1.
	*/
	// Solution 2: O(nlogn)
	private static int meetingRooms_sort(ArrayList<ArrayList<Integer>> A) {
		// Form arrays of start and end times
		int[] start_array = new int[A.size()];
		int[] end_array = new int[A.size()];
		for (int i=0; i<A.size(); i++) {
			start_array[i] = A.get(i).get(0);
			end_array[i] = A.get(i).get(1);
		}

		// Sort both start and end times separately
		Arrays.sort(start_array);
		Arrays.sort(end_array);

		// Iterate through sorted arrays, compare earliest start
		// and end time and keep incrementing num_rooms accordingly 
		// (everytime when earliest_start_time < earliest_end_time, increment num_rooms)
		int num_rooms = 0;
		int i=0, j=0;
		while(i<A.size() && j<A.size()) {
			// Compare earliest start time and end time
			if (start_array[i] < end_array[j]) {
				num_rooms++;	// Open new room
				i++;			// Move to meeting with next earliest start time
			} else {			// Earliest Start time > Earliest end time (=> same room can be used)
				i++;			// Move to meeting with next earliest start time			
				j++;			// Move to meeting with next earliest end time
			}
		}

		return num_rooms;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3); list.add(27); A.add(new ArrayList<>(list)); list.clear();
		list.add(5); list.add(21); A.add(new ArrayList<>(list)); list.clear();
		list.add(2); list.add(8); A.add(new ArrayList<>(list)); list.clear();
		list.add(4); list.add(16); A.add(new ArrayList<>(list)); list.clear();
		list.add(15); list.add(21); A.add(new ArrayList<>(list)); list.clear();
		list.add(10); list.add(20); A.add(new ArrayList<>(list)); list.clear();
		list.add(17); list.add(29); A.add(new ArrayList<>(list)); list.clear();
		list.add(23); list.add(25); A.add(new ArrayList<>(list)); list.clear();

		int num = meetingRooms_sort(A);
		System.out.println(num);
	}
}