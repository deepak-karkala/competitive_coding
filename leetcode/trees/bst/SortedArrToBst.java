/*
108. Convert Sorted Array to Binary Search Tree
Easy
9.3K
465
Companies
Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced binary search tree.
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

public class SortedArrToBst {
	// Recursive solution [DFS]
	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTRecurse(nums, 0, nums.length-1);
    }

    public static TreeNode sortedArrayToBSTRecurse(int[] nums, int low, int high){
    	TreeNode root = null;
    	if (low <= high) {
	    	int mid = low + (high-low)/2;
	    	root = new TreeNode(nums[mid]);
    		root.left = sortedArrayToBSTRecurse(nums, low, mid-1);
    		root.right = sortedArrayToBSTRecurse(nums, mid+1, high);
    	}
    	return root;
    }

    // Iterative solution [BFS]
    public static TreeNode sortedArrayToBSTIterative(int[] nums){
    	if (nums==null || nums.length==0) return null;

    	Queue<Node> queue = new LinkedList<>();
    	int low = 0, high = nums.length-1;
    	int mid = low + (high-low)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	queue.offer(new Node(root, low, high));

    	while(!queue.isEmpty()){
    		//int size = queue.size();
    		//for(int i=0; i<size; i++){
    			Node node = queue.poll();

    			//Compute mid for this node
    			mid = node.low + (node.high-node.low)/2;

    			//If not leaf node, assign left and right subtrees
    			if (mid != node.low) {
    				TreeNode left = new TreeNode(nums[node.low + (mid-1-node.low)/2]);
    				node.node.left = left;
    				queue.offer(new Node(left, node.low, mid-1));
    			}
    			if (mid != node.high) {
    				TreeNode right = new TreeNode(nums[mid+1 + (node.high-(mid+1))/2]);
    				node.node.right = right;
    				queue.offer(new Node(right, mid+1, node.high));
    			}
    		//}
    	}
    	return root;
    }
    private static class Node {
    	TreeNode node;
    	int low, high;
    	Node(TreeNode node, int low, int high){
    		this.node = node;
    		this.low = low;
    		this.high = high;
    	}
    }


    // For printing tree
    public static List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		inOrderTraversalRecursive(root, list);
		return list;
	}

	public static void inOrderTraversalRecursive(TreeNode root, List<Integer> list) {
		if (root != null) {
			inOrderTraversalRecursive(root.left, list);
			list.add(root.val);
			inOrderTraversalRecursive(root.right, list);
		}
	}

	public static void main(String[] args){
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = sortedArrayToBSTIterative(nums);
		System.out.println(inOrderTraversal(root));
	}
}