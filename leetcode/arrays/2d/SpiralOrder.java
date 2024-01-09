/*
54. Spiral Matrix
Medium
Topics
Companies
Hint
Given an m x n matrix, return all elements of the matrix in spiral order.
*/
import java.util.*;

class SpiralOrder {
    private static List<Integer> spiralOrder(int[][] matrix) {
        int numRows = matrix.length, numCols = matrix[0].length;

        int top = 0, bottom = numRows - 1;
        int left= 0, right = numCols - 1;

        List<Integer> list = new ArrayList<>();

        while(true) {
        	// Go right
        	for(int i = left; i <= right; i++) list.add(matrix[top][i]);
        	top++;
        	if (top > bottom) break;

        	// Go down
        	for(int i = top; i <= bottom; i++) list.add(matrix[i][right]);
        	right--;
        	if (right < left) break;

        	// Go left
        	for(int i = right; i >= left; i--) list.add(matrix[bottom][i]);
        	bottom--;
        	if (bottom < top) break;

        	// Go up
        	for(int i = bottom; i >= top; i--) list.add(matrix[i][left]);
        	left++;
        	if (left > right) break;
        }
        return list;
    }

    public static void main(String[] args) {
    	int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	List<Integer> list = spiralOrder(matrix);
    	for(int i: list) System.out.print(i + " ");
    }
}