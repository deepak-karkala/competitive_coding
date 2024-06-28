/*
380. Insert Delete GetRandom O(1)
Medium
Topics
Companies
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
*/

class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();        
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        // Swap the element to be deleted with last element in list
        int loc = map.get(val);
        if (loc < list.size() - 1) {
            int valInLastLoc = list.get(list.size() - 1);
            list.set(loc, valInLastLoc);
            map.put(valInLastLoc, loc);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */