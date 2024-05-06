/*
752. Open the Lock
Solved
Medium
Topics
Companies
Hint
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
*/

class OpenLock {
    public int openLock(String[] deadends, String target) {
        int numTurns = 0;
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        if (deadSet.contains("0000")) return -1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) return numTurns;
                
                if (deadSet.contains(curr)) continue;
                queue.addAll(getNeighbours(curr));
                deadSet.add(curr);
                
                /*
                for (String n: getNeighbours(curr)) {
                    if (deadSet.contains(n)) continue;
                    deadSet.add(n); // Equivalent to marking this node as visited
                    queue.offer(n);
                }
                */
            }
            numTurns++;
        }
        return -1;
    }

    public List<String> getNeighbours(String node) {
        List<String> neighbours = new ArrayList<>();
        for(int i = 0; i < node.length(); i++) {
            int pos = node.charAt(i) - '0';
            neighbours.add(node.substring(0, i) + String.valueOf((10 + pos + 1) % 10) + node.substring(i + 1));
            neighbours.add(node.substring(0, i) + String.valueOf((10 + pos - 1) % 10) + node.substring(i + 1));
            /*
            neighbours.add(node.substring(0, i) + String.valueOf(pos==0 ? 9 : pos-1) + node.substring(i + 1));
            neighbours.add(node.substring(0, i) + String.valueOf(pos==9 ? 0 : pos+1) + node.substring(i + 1));
            */
        }        
        return neighbours;
    }
}