'''
460. LFU Cache
Solved
Hard
Topics
Companies
Design and implement a data structure for a Least Frequently Used (LFU) cache.

Implement the LFUCache class:

LFUCache(int capacity) Initializes the object with the capacity of the data structure.
int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

The functions get and put must each run in O(1) average time complexity.
'''

class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.freq = 1
        self.prev = self.next = None

class DoublyLinkedList:
    def __init__(self):
        self._sentinel = Node(None, None) # dummy node
        self._sentinel.next = self._sentinel.prev = self._sentinel
        self._size = 0
    
    def __len__(self):
        return self._size
    
    def append(self, node):
        node.next = self._sentinel.next
        node.prev = self._sentinel
        node.next.prev = node
        self._sentinel.next = node
        self._size += 1
    
    def pop(self, node=None):
        if self._size == 0:
            return
        
        if not node:
            node = self._sentinel.prev

        node.prev.next = node.next
        node.next.prev = node.prev
        self._size -= 1
        
        return node

class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self._size = 0
        self._capacity = capacity
        # Mapping from key to node
        self._node = dict() # key: Node
        # Mapping from freq to doubly linked list with nodes of that freq
        self._freq = collections.defaultdict(DoublyLinkedList)
        self._minfreq = 0
    
    def _update(self, node):
        freq = node.freq
        # Remove node from current freq
        self._freq[freq].pop(node)
        # When node is popped, if the list becomes empty,
        #       increment minfreq
        if self._minfreq == freq and not self._freq[freq]:
            self._minfreq += 1

        # Insert node at the front of freq + 1
        node.freq += 1
        freq = node.freq
        self._freq[freq].append(node)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self._node:
            return -1
        
        node = self._node[key]
        self._update(node)
        return node.val
        

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """
        if self._capacity == 0:
            return
        
        if key in self._node:
            node = self._node[key]
            self._update(node)
            node.val = value
        else:
            if self._size == self._capacity:
                # Remove the last node (least recently used) from
                #   minfreq (least frequently used)
                node = self._freq[self._minfreq].pop()
                del self._node[node.key]
                self._size -= 1
            
            node = Node(key, value)
            # Add to list of key->node mapping
            self._node[key] = node
            # Append to doubly linked list at freq = 1
            self._freq[1].append(node)
            self._minfreq = 1
            self._size += 1
            


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)