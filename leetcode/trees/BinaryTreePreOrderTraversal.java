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
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorderTraversalRecurse(root, list);
        return list;
    }

    public static TreeNode preorderTraversalRecurse(TreeNode root, List<Integer> list) {
    	if (root != null){
            list.add(root.val);
			TreeNode left = preorderTraversalRecurse(root.left, list);
			TreeNode right = preorderTraversalRecurse(root.right, list);
		}
		return root;
    }

    public static void main(String[] args){
    	TreeNode left = new TreeNode();
    	TreeNode right = new TreeNode(2, new TreeNode(3), null);
    	TreeNode root = new TreeNode(1, null, right);
    	List<Integer> list = preorderTraversal(root);
    	System.out.println(list);
    }
}