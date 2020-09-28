package dynamic_programming;

import java.util.Iterator;
import java.util.Stack;

/*
 * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 
 * 3 towers and N disks of different sizes which can slide onto any tower. 
 * The puzzle starts with disks sorted in ascending order of size from top 
 * to bottom (i.e., each disk sits on top of an even larger one). You have 
 * the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last using Stacks.
 */


class Tower {
	// Index to identify tower
	private int index;
	// Stack to hold disks
	private Stack<Integer> disks;
	
	// Constructor
	Tower(int index) {
		disks = new Stack<Integer>();
		this.index = index;
	}
	
	// Returns index
	public int getIndex() {
		return index;
	}
	
	// Add disk
	public void add(int d) {
		//System.out.println(d);
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk");
		}
		disks.push(d);
	}
	
	// Move top disk
	public void moveTopDisk(Tower destination) {
		destination.add(disks.pop());
	}
	
	// Move Disks from one origin to destination using buffer
	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n>0) {
			moveDisks(n-1, buffer, destination);
			moveTopDisk(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}
	
	// Show disks on tower
	public void showDisks() {
		System.out.println("Disks in tower" + index + ": ");
		Iterator<Integer> itr = disks.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
		}
		
	}
	
}

public class TowersOfHanoi {
	public static void main(String[] args) {
		// Declare 3 towers
		int numTowers = 3;
		Tower[] tower = new Tower[numTowers];
		for (int i=0; i<numTowers; i++) {
			tower[i] = new Tower(i);
		}
		
		// Place N disks onto first tower
		int numDisks = 5;
		for(int i=numDisks-1; i>=0; i--) {
			tower[0].add(i);
		}
		
		// Show disks in all three towers
		tower[0].showDisks();
		tower[1].showDisks();
		tower[2].showDisks();

		// Move disks from first to third tower
		tower[0].moveDisks(numDisks, tower[2], tower[1]);
		
		// Show disks in all three towers
		tower[0].showDisks();
		tower[1].showDisks();
		tower[2].showDisks();
	}
}
