/*
2336. Smallest Number in Infinite Set
Medium
Topics
Companies
Hint
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set, if it is not already in the infinite set.
*/
import java.util.*;

class SmallestInfiniteSet {

	// Using PQ
	/*
	int minNum;
	PriorityQueue<Integer> heap;
    
    public SmallestInfiniteSet() {
        minNum = 1;
        heap = new PriorityQueue<>()
    }
    
    public int popSmallest() {
    	if (!heap.isEmpty()) return heap.poll();
        minNum++;
        return minNum - 1;
    }
    
    public void addBack(int num) {
        if (minNum > num && !heap.contains(num)) heap.offer(num);
    }
	*/

	// Using TreeSet
	int minNum;
	TreeSet<Integer> set;
    
    public SmallestInfiniteSet() {
        minNum = 1;
        set = new TreeSet<>();
    }
    
    public int popSmallest() {
    	if (!set.isEmpty()) return set.pollFirst();
        minNum++;
        return minNum - 1;
    }
    
    public void addBack(int num) {
        if (minNum > num) set.add(num);
    }


    public static void main(String[] args) {
    	SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
		smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
		smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
		                                   // is the smallest number, and remove it from the set.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
		System.out.println(smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }
}