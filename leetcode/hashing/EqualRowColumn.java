/*
2352. Equal Row and Column Pairs
Medium
Topics
Companies
Hint
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
*/
import java.util.*;

class EqualRowColumn {
    /*
        // Iterate through row, convert to string, insert into hashmap with value count
        // Iterate through columns, convert to string, count how many times this 
        //      occurs as keys in hashmap with rows represented as String 
    */
    private static int equalPairs(int[][] grid) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int nPairs = 0;

        // Iterate through row, convert to string, insert into hashmap with value count
        for(int[] row: grid) {
            //String rowStr = "";// = Arrays.toString(row);
            //for(int v: row) rowStr += v;
            String rowStr = Arrays.toString(row);
            hmap.put(rowStr, hmap.getOrDefault(rowStr, 0) + 1);
        }
        
        
        /*for(String key: hmap.keySet()) {
            System.out.println(key + "-" + hmap.get(key));
        }*/

        // Iterate through columns, convert to string, count how many times this 
        //      occurs as keys in hashmap with rows represented as String 
        for(int col=0; col<grid[0].length; col++) {
            String colStr = "[";
            for(int row=0; row<grid.length; row++) {
                if (row == grid.length-1) colStr += grid[row][col];
                else colStr += grid[row][col] + ", ";
            }
            colStr += "]";
            //System.out.println(colStr);

            nPairs += hmap.getOrDefault(colStr, 0);
        }
        return nPairs;
    }

    public static void main(String[] args) {
    	int[][] grid = {{3,1,2,2}, {1,4,4,5}, {2,4,2,2}, {2,4,2,2}};
    	System.out.println(equalPairs(grid));
    }
}