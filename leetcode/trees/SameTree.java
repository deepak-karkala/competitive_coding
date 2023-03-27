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
		Compare the equality of Pre-order traversals of both trees
	*/
	public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
		List<Integer> plist = new ArrayList<>();
		List<Integer> qlist = new ArrayList<>();

		preorderTraversalRecurse(p, plist);
		preorderTraversalRecurse(p, qlist);

		return plist.equals(qlist);
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
    	TreeNode p = new TreeNode(1, left1, right1);

    	TreeNode left2 = new TreeNode(2, null, null);
    	TreeNode right2 = new TreeNode(3, null, null);
    	TreeNode q = new TreeNode(1, right2, left2);

    	System.out.println(isSameTreeIterative(p, q));
	}
}