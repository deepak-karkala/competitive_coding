/*
MinHeap implementation
*/

public class MinHeap {
	int[] heap;
	int heapsize = 0;
	int maxSize = 0;

	// Constructor
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		heap = new int[maxSize];
	}

	// Get index of left child
	public int getLeftChild(int pos){
		return 2*pos;
	}

	// Get index of right child
	public int getRightChild(int pos){
		return 2*pos+1;
	}

	// Get index of parent
	public int getParent(int pos){
		return Math.floorDiv(pos, 2);
	}

	// Get min
	public int getMin(){
		return heap[0];
	}

	// Swap elements
	public void swap(int pos1, int pos2){
		pos1--;
		pos2--;
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	// Check if leaf node (node index >= heapSize/2+1)
	public boolean isLeaf(int pos){
		int leafNodeStartIdx = Math.floorDiv(heapSize/2)+1;
		int leafNodeEndIdx = heapSize;
		return ((pos>=leafNodeStartIdx) && (pos<=leafNodeEndIdx)) ? true : false;
	}


	public static void main(String[] args){

	}
}