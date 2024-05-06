/*
279. Perfect Squares
Solved
Medium
Topics
Companies
Given an integer n, return the least number of perfect square numbers that sum to n.
*/

class NumPerfectSquares {
    public int numSquares(int n) {
        int depth = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for(int i = 0; i < size; i++) {
                int curr = queue.poll();

                for(int num = 1; num * num <= n; num++) {
                    int next = curr + num * num;
                    if (next == n) return depth;
                    if (next > n) break;
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return depth;
    }
}