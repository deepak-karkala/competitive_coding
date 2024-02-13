/*
872. Leaf-Similar Trees
Solved
Easy
Topics
Companies
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence
*/

class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeafSequence(root1);
        List<Integer> list2 = getLeafSequence(root2);
        return list1.equals(list2);
    }

    public List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return getLeafSequence(root, list);
    }

    public List<Integer> getLeafSequence(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        if (root.left == null && root.right == null) {list.add(root.val); return list;}
        list = getLeafSequence(root.left, list);
        list = getLeafSequence(root.right, list);
        return list;
    }
}