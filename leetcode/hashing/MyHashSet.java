/*
705. Design HashSet
Easy
Topics
Companies
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
*/

class MyHashSet {

	/*
		Key Range: 0 to 10^6
		Each int: 32 bits
		Assume: Represent each key as a bit
			=> Total number of buckets = 1000000 / 32 = 31250
		Each bucket contains keys from (0-31), (32-63) and so on
	*/
	/*
    int[] set;
    public MyHashSet() {
		set = new int[31251];
    }
    
    public void add(int key) {
        set[getBucketId(key)] |= getMask(key); 
    }
    
    public void remove(int key) {
        set[getBucketId(key)] &= ~getMask(key);
    }
    
    public boolean contains(int key) {
        return (set[getBucketId(key)] & getMask(key)) != 0; 
    }

    public int getBucketId(int key) {
    	return key / 32;
    }

    public int getMask(int key) {
    	return 1 << (key % 32);
    }
    */

	/*
		Use array of LinkedList as data structure
		Set initial capacity to 1000. LoadFactor = 0.75
			=> When any particular linkedList gets filled with 750 keys, 
				rehash with double the capacity.
			During rehash, map all the present entries to new Array of Linkedlist
	*/
	List<Integer>[] container;
	int capacity = 1000;
	double loadFactor = 0.75;
	int count = 0;
    
    public MyHashSet() {
		container = new LinkedList[capacity];
    }
    
    public void add(int key) {
    	// Do nothing if key already present
        if (contains(key)) return;

        // If count exceeds loadFactor, rehash
        if (capacity * loadFactor == count) {
        	count = 0;		// Reset count to 0
        	capacity *= 2;
        	List<Integer>[] oldContainer = container;
        	container = new LinkedList[capacity];

        	// Copy all the present entries to hash table with new capacity
        	for(int i=0; i<oldContainer.length; i++) {
        		List<Integer> list = oldContainer[i];
        		if (list != null) {
	        		Iterator<Integer> itr = list.iterator();
    	    		while(itr.hasNext())
        				this.add(itr.next());
        		}
        	}
        }

        // Hash funtion
        int hash = key % capacity;
        if (container[hash] == null)
        	container[hash] = new LinkedList<>();
        container[hash].add(key);
        count++;	// Update number of keys inserted
        return;
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> list = container[hash];
        if (list != null) {
        	Iterator<Integer> itr = list.iterator();
        	while(itr.hasNext())
        		if (itr.next() == key) {
        			itr.remove();
        			count--;
        			break;
        		}
        }
    }
    
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> list = container[hash];
        if (list != null) {
        	Iterator<Integer> itr = list.iterator();
	        while(itr.hasNext())
	        	if (itr.next() == key) return true;
	    }
        return false;
    }


    public static void main(String[] args) {
    	MyHashSet hs = new MyHashSet();
    	hs.add(50);
    	hs.add(34);
    	System.out.println(hs.contains(34));
    	hs.remove(34);
    	System.out.println(hs.contains(34));
    	System.out.println(hs.contains(50));
    }
}