/*
841. Keys and Rooms
Solved
Medium
Topics
Companies
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.
*/

class KeysAndRooms {
    // DFS - Recursion Stack
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for(boolean visit: visited) if (!visit) return false;
        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        // Visit all rooms with keys present in this room
        for(int key: rooms.get(room))
            if (!visited[key]) dfs(key, rooms, visited);
        return;
    }

    // DFS - Stack
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); dfs.add(0);
        HashSet<Integer> seen = new HashSet<Integer>(); seen.add(0);
        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!seen.contains(j)) {
                    dfs.add(j);
                    seen.add(j);
                    if (rooms.size() == seen.size()) return true;
                }
        }
        return rooms.size() == seen.size();
    }

    // BFS
    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
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
        			if (roomsVisited.size() == n) return true;
        		}
        	}
        }
        // Check if all rooms are visited
        return roomsVisited.size() == n;
    }
}