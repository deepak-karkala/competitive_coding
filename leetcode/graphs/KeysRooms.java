/*
841. Keys and Rooms
Medium
5.7K
250
Companies
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number
on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited
room i, return true if you can visit all the rooms, or false otherwise.

*/

import java.util.*;

class KeysRooms {
	/*
	Approach: BFS
		Keep visiting all nodes starting from room 0 (BFS)
		At the end, check if all nodes can be visited
	*/
    private static boolean canVisitAllRooms_bfs(List<List<Integer>> rooms) {
        int n = rooms.size();
        List<Integer> roomsVisited = new ArrayList<Integer>();

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        roomsVisited.add(0);

        while(!queue.isEmpty()) {
        	int roomId = queue.poll();
        	// Get keys from this room and visit all these rooms
        	for(int room: rooms.get(roomId)) {
        		// If current room has not been visited yet, add to queue (BFS)
        		if (!roomsVisited.contains(room)) {
        			roomsVisited.add(room);
        			queue.offer(room);
        		}
        	}
        }
        // Check if all rooms are visited
        return roomsVisited.size() == n;
    }

    public static void main(String[] args) {
    	List<List<Integer>> rooms = new ArrayList<List<Integer>>();
    	rooms.add(new ArrayList<>(Arrays.asList(1)));
    	rooms.add(new ArrayList<>(Arrays.asList(2)));
    	rooms.add(new ArrayList<>(Arrays.asList(3)));
    	rooms.add(new ArrayList<>(Arrays.asList()));

    	System.out.println(canVisitAllRooms_bfs(rooms));
    }
}