/*
173. Binary Search Tree Iterator
Medium
7.4K
445
Companies
Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
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
 
public class BSTIterator {
	// Naive
	ArrayList<Integer> list = new ArrayList<Integer>();
	int pointer = 0;
	public BSTIterator(TreeNode root) {
		 // Populate list with nodes in in-order traversal
		 recurse(root, list);
		 return;
    }
    
    public static void recurse(TreeNode node, ArrayList<Integer> list) {
    	if (node == null) return;
    	recurse(node.left, list);
    	list.add(node.val);
    	recurse(node.right, list);
    }

    public int next() {
        return list.get(pointer++);
    }
    
    public boolean hasNext() {
    	return pointer < list.size();
    }


    public static void main(String[] args) {
    	TreeNode left = new TreeNode(3, null, null);
    	TreeNode right = new TreeNode(15, new TreeNode(9), new TreeNode(20));
    	TreeNode root = new TreeNode(7, left, right);

    	BSTIterator bSTIterator = new BSTIterator(root);
    	System.out.println(bSTIterator.next());    // return 3

		System.out.println(bSTIterator.next());    // return 7
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next());    // return 9
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next());    // return 15
		System.out.println(bSTIterator.hasNext()); // return True
		System.out.println(bSTIterator.next());    // return 20
		System.out.println(bSTIterator.hasNext()); // return False
    }
}