/*
706. Design HashMap
Easy
Topics
Companies
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
*/
import java.util.*;

class ListNode {
	int key, val;
	ListNode next;
	ListNode(int key, int value, ListNode next) {
		this.key = key;
		this.val = value;
		this.next = next;
	}
}

class MyHashMap {

	/*
		Using arrays of custom ListNode as Data structure
	*/
	ListNode[] lists;
	int capacity = 10000;

	public MyHashMap() {
        lists = new ListNode[capacity];
    }

    public void put(int key, int value) {
    	remove(key);
    	int hash = getHash(key);
    	ListNode node = new ListNode(key, value, lists[hash]);
    	lists[hash] = node;
    }

    public int get(int key) {
    	int hash = getHash(key);
    	ListNode node = lists[hash];
    	while(node != null) {
    		if (node.key == key) return node.val;
    		node = node.next;
    	}
    	return -1;
    }

    public void remove(int key) {
    	int hash = getHash(key);
    	ListNode node = lists[hash];
    	// If the list is empty, return
    	if (node == null) return;
    	
    	// If desired key is at the head of the list
    	if (node.key == key) {
    		lists[hash] = node.next;
    		return;
    	}

    	// If desired key is somewhere in between
    	while(node.next != null) {
    		if (node.next.key == key) {
    			node.next = node.next.next;
    			return;
    		}
    		node = node.next;
    	}
    }

    public int getHash(int key) {
    	return key % capacity;
    }

	/*
		Use Array of Linkedlist as DS, Each linkedlist entry is int[],
			int[0]->key, int[1]->value
	List<int[]>[] container;
	int capacity = 1000;
	double loadFactor = 0.75;
	int count = 0;

    public MyHashMap() {
        container = new ArrayList[capacity];
    }
    
    public void put(int key, int value) {
        int hash = key % capacity;
    	// If key already present, update the value
    	if (get(key) != -1) {
    		List<int []> list = container[hash];
	        if (list != null) {
	        	int size = list.size();
	        	for(int i=0; i<size; i++) {
	        		if (list.get(i)[0] == key) list.set(i, new int[]{key, value});
	        	}
	        }
	        return;
    	}

    	// If count exceeds loadFactor, rehash
        if (capacity * loadFactor == count) {
        	count = 0;		// Reset count to 0
        	capacity *= 2;
        	List<int[]>[] oldContainer = container;
        	container = new ArrayList[capacity];

        	// Copy all the present entries to hash table with new capacity
        	for(int i=0; i<oldContainer.length; i++) {
        		List<int[]> list = oldContainer[i];
        		if (list != null) {
	        		Iterator<int[]> itr = list.iterator();
    	    		while(itr.hasNext()) {
    	    			int[] arr = itr.next();
        				this.put(arr[0], arr[1]);
        			}
        		}
        	}
        }

        // Hash funtion
        if (container[hash] == null)
        	container[hash] = new ArrayList<int[]>();
        container[hash].add(new int[]{key, value});
        count++;	// Update number of keys inserted
        return;
    }
    
    public int get(int key) {
        int hash = key % capacity;
        List<int []> list = container[hash];
        if (list != null) {
	        for(int[] arr: list) {
	        	//System.out.println(arr[0] + "--" + arr[1]);
	        	if (arr[0] == key) return arr[1];
	        }
	    }
	    return -1;
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        List<int []> list = container[hash];
        if (list != null) {
        	Iterator<int[]> itr = list.iterator();
        	while(itr.hasNext()) {
        		int[] arr = itr.next();
        		if (arr[0] == key) {
        			itr.remove();
        			count--;
        			break;
        		}
        	}
        }
    }
	*/

    public static void main(String[] args) {
    	MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1); // The map is now [[1,1]]
		myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
		System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
		myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
		System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
		myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
		System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}



