/*
146. LRU Cache
Medium
Topics
Companies
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.
*/

class LRUCache {
    private final int CAPACITY;
    private HashMap<Integer, Node> map;
    private DoubleLinkedList list;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new HashMap(capacity);
        list = new DoubleLinkedList();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        list.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            if (map.size() == CAPACITY) {
                Node tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        } else {
            list.moveToHead(node);
            node.value = value;
        }
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }

    void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    void addToHead(Node node) {
        Node currHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currHead;
        currHead.prev = node; 
    }

    Node getTail() {
        return tail.prev;
    }

    void removeTail() {
        Node newTail = tail.prev.prev;
        newTail.next = tail;
        tail.prev = newTail;        
    }
}

class Node {
    int key, value;
    Node next, prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/*
class LRUCache {
    private final int CAPACITY;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };        
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
*/