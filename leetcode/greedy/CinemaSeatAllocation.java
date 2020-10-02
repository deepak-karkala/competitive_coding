package greedy;

import java.util.HashMap;
import java.util.Map;

/*
 * A cinema has n rows of seats, numbered from 1 to n and there are
 * ten seats in each row, labelled from 1 to 10 as shown in the figure above.

Given the array reservedSeats containing the numbers of seats already
reserved, for example, reservedSeats[i] = [3,8] means the seat located
in row 3 and labelled with 8 is already reserved.

Return the maximum number of four-person groups you can assign on the
cinema seats. A four-person group occupies four adjacent seats in one
single row. Seats across an aisle (such as [3,3] and [3,4]) are not
considered to be adjacent, but there is an exceptional case on which
an aisle split a four-person group, in that case, the aisle split a 
four-person group in the middle, which means to have two people
on each side.
 */


public class CinemaSeatAllocation {
	
	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int numFamilies = 0;
        
        // Convert int array to hasmap of bit vectors
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int [] reserved: reservedSeats) {
        	int row = reserved[0];
        	int col = reserved[1];
        	// Create bit vectors
        	hmap.put(row, hmap.getOrDefault(row, 0) | (1 << col));
        }
        
        int numFamiliesInReservedRows = 0;
        for (int row : hmap.keySet()) {
        	int rowBitMap = hmap.get(row);
        	int numFamiliesPerRow = 0;
        	if ((rowBitMap & 60) == 0) numFamiliesPerRow += 1;
        	if ((rowBitMap & 960) == 0) numFamiliesPerRow += 1;
        	if (((rowBitMap & 240) == 0) && numFamiliesPerRow==0) numFamiliesPerRow += 1;
        	
        	numFamiliesInReservedRows += numFamiliesPerRow;
        }
        
        int numFamiliesInUnreservedRows = 2 * (n - hmap.size());
        
        numFamilies = numFamiliesInReservedRows + numFamiliesInUnreservedRows;
        return numFamilies;
    }
	
	public static void main(String[] args) {
		CinemaSeatAllocation cs = new CinemaSeatAllocation();
		int n = 3; //reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
		int[][] reservedSeats = {{1,2}, {1,3}, {1,8}, {2,6}, {3,1}, {3,10} };
		int numWays = cs.maxNumberOfFamilies(n, reservedSeats);
		System.out.println(numWays);
	}
}