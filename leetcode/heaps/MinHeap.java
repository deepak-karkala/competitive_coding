/*
MinHeap implementation
*/


class MinHeap {
	int[] heap;
	int maxSize = 0;
	int heapSize = 0;

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

	// Get size
	public int size(){
		return heapSize;
	}

	// Return minimum from heap
	public int peek() {
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
		int leafNodeStartIdx = (heapSize / 2) + 1;
		int leafNodeEndIdx = heapSize;
		return ((pos>=leafNodeStartIdx) && (pos<=leafNodeEndIdx)) ? true : false;
	}

	// Swaps elements to create min heap at given node
	public void minHeapify(int pos) {
		int leftChildIdx = getLeftChild(pos); 
		int rightChildIdx = getRightChild(pos);
		int smallest = pos;

		if (leftChildIdx <= heapSize && heap[leftChildIdx-1] < heap[smallest-1]) smallest = leftChildIdx;
		if (rightChildIdx <= heapSize && heap[rightChildIdx-1] < heap[smallest-1]) smallest = rightChildIdx;

		if (smallest != pos) {
			swap(smallest, pos);
			minHeapify(smallest);
		}
		return;
	}
	
	// Build min heap
	public void buildMinHeap() {
		int pos = heapSize;
		while(pos >= 1)
			minHeapify(pos--);
		return;
	}
	
	// Heapsort algorithm
	public void heapSort() {
		int tmp = heapSize;
		buildMinHeap();

		while(heapSize > 0) {
			swap(1, heapSize);
			heapSize--;
			minHeapify(1);
		}
		heapSize = tmp;
	}
	

	// Extract minimum, return and remove minimum from heap
	public int pop() {
		int min = heap[0];
		heap[0] = heap[heapSize-1];	// Insert last element at top
		heapSize--;
		minHeapify(1);
		return min;
	}
	
	//Insert new element 
	public void push(int key) {
		heapSize++;
		if (heapSize == maxSize) {
			heapSize--;
			throw new ArrayIndexOutOfBoundsException();
		}

		heap[heapSize-1] = key;
		int index = heapSize;
		int parent = getParent(index);

		while(index > 1 && heap[parent-1] > heap[index-1]) {
			swap(parent, index);
			index = parent;
			parent = getParent(parent);
		}
		return;
	}

	public void insert_arr_elems_to_heap(int[] arr) {
		for (int n: arr) push(n);
	}

	public static void main(String[] args) {
		int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		MinHeap pq = new MinHeap(20);
		pq.insert_arr_elems_to_heap(arr);
		pq.buildMinHeap();
		for(int n: pq.heap) System.out.print(n + " ");
		System.out.println("");
		System.out.println(pq.peek());
		pq.heapSort();
		for(int n: pq.heap) System.out.print(n + " ");
	}

	
}