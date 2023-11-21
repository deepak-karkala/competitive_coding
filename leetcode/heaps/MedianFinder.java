/*
295. Find Median from Data Stream
Hard
Topics
Companies
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
*/

import java.util.*;

class MedianFinder {

	PriorityQueue<Integer> large = new PriorityQueue<>();				// Min Heap
	PriorityQueue<Integer> small = new PriorityQueue<>((a,b) -> b-a);	// Max Heap        
    
    public MedianFinder() {
		
    }
    
    public void addNum(int num) {
		large.add(num);
		small.add(large.poll());

		if (large.size() < small.size()) large.add(small.poll());        
    }
    
    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
    }

    public static void main(String[] args) {
    	MedianFinder obj = new MedianFinder();
 		obj.addNum(1);
 		obj.addNum(2);
		System.out.println(obj.findMedian());
 		obj.addNum(3);
		System.out.println(obj.findMedian());
    }
}

