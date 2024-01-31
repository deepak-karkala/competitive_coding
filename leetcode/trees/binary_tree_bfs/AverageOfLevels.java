/*
637. Average of Levels in Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
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

class AverageOfLevels {
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) return list;
        getAverageLevel(root, lists, 0);
        for(int i=0; i<lists.size(); i++){
            double avg = 0;
            for(int j=0; j<lists.get(i).size(); j++) avg += lists.get(i).get(j);
            avg /= lists.get(i).size();
            list.add(avg);
        }
        return list;
    }

    private static void getAverageLevel(TreeNode root, List<List<Integer>> lists, int level) {
        if (root == null) return;
        if (level >= lists.size()) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        getAverageLevel(root.left, lists, level+1);
        getAverageLevel(root.right, lists, level+1);
        return;
    }

    private static List<Double> averageOfLevelsBfs(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            double avg = 0;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                avg += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);        
            }
            avg /= size;
            list.add(avg);
        }
        return list;
    }

    private static List<Double> averageOfLevelsBfs2(TreeNode root) {
        List<Double> result = new ArrayList<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    
	    if(root == null) return result;
	    q.add(root);
	    while(!q.isEmpty()) {
	        int n = q.size();
	        double sum = 0.0;
	        for(int i = 0; i < n; i++) {
	            TreeNode node = q.poll();
	            sum += node.val;
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	        result.add(sum / n);
	    }
	    return result;
    }

    public static void main(String[] args) {
    	TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    	List<Double> list = averageOfLevelsBfs(root);
    	for(Double d: list) System.out.print(d + " ");
    }
}