/*
559. Maximum Depth of N-ary Tree
Easy
Topics
Companies
Given a n-ary tree, find its maximum depth.
*/

class NaryMaxDepth {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for(Node child: root.children) max = Math.max(max, maxDepth(child));
        return max + 1;
    }
}