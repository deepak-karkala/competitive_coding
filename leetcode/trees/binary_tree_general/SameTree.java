/*
100. Same Tree
Easy
9.1K
181
Companies
Given the roots of two binary trees p and q, write a function to check if
they are the same or not.
Two binary trees are considered the same if they are structurally identical,
and the nodes have the same value.
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

public class SameTree {

	/* Recursive
	*/
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		// Base case - both at leaf level
		if (p==null && q==null) return true;
		
		// If only one of them is null, return false (not same tree)
		if (p==null || q==null) return false;
		
		// Now we come to case of both not being null
		// Now check for value equality
		if (p.val != q.val) return false;
		
		// Now both are not null and values match at this level
		// Now check for left and right subtree equality
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	/* Recursive
		Compare the equality of Pre-order traversals of both trees
	*/
	public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
		List<Integer> plist = new ArrayList<>();
		List<Integer> qlist = new ArrayList<>();

		preorderTraversalRecurse(p, plist);
		preorderTraversalRecurse(q, qlist);

		return plist.equals(qlist);
	}

	public static void preorderTraversalRecurse(TreeNode root, List<Integer> list){
		if (root != null) {
			list.add(root.val);
			preorderTraversalRecurse(root.left, list);
			preorderTraversalRecurse(root.right, list);
		} else {
			list.add(Integer.MAX_VALUE);
		}
		return;
	}

	/* Iterative using stack
		Pre-order traversals of both trees and then compare for equality at every node
	*/
	public static boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Deque<TreeNode> pstack = new LinkedList<TreeNode>();
        Deque<TreeNode> qstack = new LinkedList<TreeNode>();

        pstack.push(p);
        qstack.push(q);
        while(!pstack.isEmpty() || !qstack.isEmpty()){

        	if (!pstack.isEmpty() && !qstack.isEmpty()) {
        		TreeNode pnode = pstack.pop();
	        	TreeNode qnode = qstack.pop();
	        	
	        	int pval, qval; 
	        	if (pnode != null) pval = pnode.val;
	        	if (qnode != null) qval = qnode.val;

	        	if (pnode==null && qnode!=null) {
	        		return false;
	        	} else if (pnode!=null && qnode==null) {
	        		return false;
	        	} else if (pnode!=null && qnode!=null) {
		        	if (pnode.val != qnode.val) return false;
	        	
		        	pstack.push(pnode.right);
		        	pstack.push(pnode.left);

		        	qstack.push(qnode.right);
		        	qstack.push(qnode.left);
		        } else {
		        	continue;
		        }
        	} else {
        		return false;
        	}
        }

        return true;
    }




	public static void main(String[] args){
		TreeNode left1 = new TreeNode(2, null, null);
    	TreeNode right1 = new TreeNode(3, null, null);
    	TreeNode p = new TreeNode(1, new TreeNode(2), null);

    	TreeNode left2 = new TreeNode();
    	TreeNode right2 = new TreeNode(2, new TreeNode(3), null);
    	TreeNode q = new TreeNode(1, null, new TreeNode(2));

    	System.out.println(isSameTree(p, q));
	}
}