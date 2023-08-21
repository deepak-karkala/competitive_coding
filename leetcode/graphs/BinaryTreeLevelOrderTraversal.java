/*
102. Binary Tree Level Order Traversal
Medium
14.1K
275
Companies
Given the root of a binary tree, return the level order traversal of
its nodes' values. (i.e., from left to right, level by level).
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


public class BinaryTreeLevelOrderTraversal {
    private static List<List<Integer>> levelOrder_iterative(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) return lists;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
        	list = new ArrayList<Integer>();
        	int size = queue.size();
        	for(int i=0; i<size; i++) {
        		TreeNode node = queue.poll();
        		if (node.left != null) queue.offer(node.left); 
        		if (node.right != null) queue.offer(node.right);
        		list.add(node.val); 
        	}
        	lists.add(list);
        }

        return lists;
    }

    private static List<List<Integer>> levelOrder_recursive_top(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	int level = 0;
    	levelOrder_recursive(root, level, lists);
    	return lists;
    }

    private static void levelOrder_recursive(TreeNode root, int level, List<List<Integer>> lists) {
    	if (root == null) return;
    	if (level >= lists.size()) {
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		list.add(root.val);
    		lists.add(list);
    	} else {
	    	lists.get(level).add(root.val);
	    }
    	levelOrder_recursive(root.left, level+1, lists);
    	levelOrder_recursive(root.right, level+1, lists);
    	return;
    }

    public static void main(String[] args) {
    	TreeNode left = new TreeNode(2, new TreeNode(4), null);
    	TreeNode right = new TreeNode(3, null, new TreeNode(5));
    	TreeNode root = new TreeNode(1, left, right);
    	System.out.println(levelOrder_recursive_top(root));
    }
}