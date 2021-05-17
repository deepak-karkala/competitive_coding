package sorting_searching;

/*
 * Rank from Stream: Imagine you are reading in a stream of integers. 
 * Periodically, you wish to be able to look up the rank of a number x 
 * (the number of values less than or equal to x). Implement the data 
 * structures and algorithms to support these operations. That is, 
 * implement the method track(int x), which is called when each number 
 * is generated, and the method getRankOfNumber(int x), which returns 
 * the number of values less than or equal to x(not including x itself). 
 */

class RankNode {
	public int data;
	public int leftSize;
	public RankNode left, right;

	public RankNode(int d) {
		data = d;
	}
	
	/* Insert new node */
	public void insert(int d) {
		if (d <= data) {
			if (left != null) {
				left.insert(d);
			} else {
				left = new RankNode(d);
			}
			leftSize++;
		} else {
			if (right != null) {
				right.insert(d);				
			} else {
				right = new RankNode(d);
			}
		}
	}
	
	/* Get Rank of Number */
	public int getRank(int x) {
		if (x == data) {
			return leftSize;
		}
		else if (x < data) {
			if (left == null) return -1;
			return left.getRank(x);
		} else {
			int rightRank = (right == null) ? -1 : right.getRank(x);
			if (rightRank == -1) return -1;
			else return leftSize + 1 + rightRank;
		}
	
	}
}


public class RankFromStream {
	
	RankNode root = null;
	
	public void track(int x) {
		if (root == null) {
			root = new RankNode(x);
		} else {
			root.insert(x);
		}
	}

	public int getRankOfNumber(int x) {
		return root.getRank(x);
	}
	
	public static void main(String[] args) {
		RankFromStream rs = new RankFromStream();
		int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};
		for(int i: stream) {
			rs.track(i);
		}
		System.out.println(rs.getRankOfNumber(7));
	}
}