/*
427. Construct Quad Tree
Medium
Topics
Companies
Given a n * n matrix grid of 0's and 1's only. We want to represent grid with a Quad-Tree.

Return the root of the Quad-Tree representing grid.

A Quad-Tree is a tree data structure in which each internal node has exactly four children. Besides, each node has two attributes:

val: True if the node represents a grid of 1's or False if the node represents a grid of 0's. Notice that you can assign the val to True or False when isLeaf is False, and both are accepted in the answer.
isLeaf: True if the node is a leaf node on the tree or False if the node has four children.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;
}
We can construct a Quad-Tree from a two-dimensional area using the following steps:

If the current grid has the same value (i.e all 1's or all 0's) set isLeaf True and set val to the value of the grid and set the four children to Null and stop.
If the current grid has different values, set isLeaf to False and set val to any value and divide the current grid into four sub-grids as shown in the photo.
Recurse for each of the children with the proper sub-grid.
*/

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

class QuadTree {
    private static Node construct(int[][] grid) {
    	return recurse(grid, 0, 0, grid.length);
    }

    private static Node recurse(int[][] grid, int x, int y, int len) {
    	// Base case (one cell => len = 1)
    	if (len == 1) {
    		// Return isLeaf = true since one node
    		return new Node(grid[x][y] != 0, true, null, null, null, null);
    	}

    	// Four recursive calls for 4 parts (len reduces by half)
    	Node topLeft 	= recurse(grid, x, y, len/2);
    	Node topRight 	= recurse(grid, x, y+len/2, len/2);
    	Node bottomLeft = recurse(grid, x+len/2, y, len/2);
    	Node bottomRight= recurse(grid, x+len/2, y+len/2, len/2);

    	// Check if 4 parts are all leaf nodes with same values
    	boolean isLeafNode = false;
    	isLeafNode = topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
    				&& topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;

    	Node result = new Node();
    	if (isLeafNode) {
    		result.isLeaf = true;
    		result.val = topLeft.val;
    	} else {
    		result.topLeft = topLeft;
    		result.topRight = topRight;
    		result.bottomLeft = bottomLeft;
    		result.bottomRight = bottomRight;
    	}
    	return result;
    }

    public static void main(String[] args) {
    	int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},
    					{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
    	Node node = construct(grid);

    }
}

