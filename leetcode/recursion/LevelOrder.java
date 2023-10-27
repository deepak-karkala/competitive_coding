/*
102. Binary Tree Level Order Traversal
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the level order traversal of its
nodes' values. (i.e., from left to right, level by level).
*/

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
	  this.val = val;
	  this.left = left;
	  this.right = right;
	}
}

class LevelOrder {
	/* Recursive */
    private static List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        recurse(root, lists, 0);
        return lists;
    }

    private static void recurse(TreeNode root, List<List<Integer>> lists, int level) {
    	if (root == null) return;

    	if (lists.size() <= level) {
    		List<Integer> list = new ArrayList<Integer>();
    		list.add(root.val);
    		lists.add(new ArrayList<>(list));
    	} else {
    		lists.get(level).add(root.val);
    	}
    	recurse(root.left, lists, level+1);
    	recurse(root.right, lists, level+1);
    	return;
    }

    /* Iterative */
    private static List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return lists;

    	Queue<TreeNode> q = new ArrayDeque<TreeNode>();
    	q.offer(root);

    	while(!q.isEmpty()) {

    		int size = q.size();
	    	List<Integer> list = new ArrayList<Integer>();
    		for(int i=0; i<size; i++) {
    			TreeNode node = q.poll();
    			list.add(node.val);

    			if (node.left != null) q.offer(node.left);
	    		if (node.right != null) q.offer(node.right);
    		}
    		lists.add(new ArrayList<>(list));
    	}
    	return lists;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    	List<List<Integer>> list = levelOrderIterative(root);
    	for(List<Integer> l: list)
	    	System.out.print(l + " ");
    }
}