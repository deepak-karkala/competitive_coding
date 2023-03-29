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
		TreeNode root = sortedArrayToBST(nums);
		System.out.println(inOrderTraversal(root));
	}
}