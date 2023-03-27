/*
144. Binary Tree Preorder Traversal
Easy
6.6K
173
Companies
Given the root of a binary tree, return the preorder traversal of its nodes' values.
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
 
public class BinaryTreePreOrderTraversal {
	/* Recursive */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversalRecurse(root, list);
        return list;
    }

    public static void preorderTraversalRecurse(TreeNode root, List<Integer> list) {
    	if (root != null){
            list.add(root.val);
			preorderTraversalRecurse(root.left, list);
			preorderTraversalRecurse(root.right, list);
		}
		return;
    }

    /* Iterative - using stack to traverse all nodes */
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	Deque<TreeNode> stack = new LinkedList<TreeNode>();
    	stack.push(root);
    	
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		if (node != null) {
    			list.add(node.val);
    			stack.push(node.right);
    			stack.push(node.left);
    		}
    	}
    	return list;
    }

    public static void main(String[] args){
    	TreeNode left = new TreeNode(4, null, null);
    	TreeNode right = new TreeNode(2, new TreeNode(3), null);
    	TreeNode root = new TreeNode(1, left, right);
    	List<Integer> list = preorderTraversalIterative(root);
    	System.out.println(list);
    }
}