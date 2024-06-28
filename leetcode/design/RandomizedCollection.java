/*
381. Insert Delete GetRandom O(1) - Duplicates allowed
Solved
Hard
Topics
Companies
RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also reporting a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of the same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.
*/

class RandomizedCollection {

    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        boolean isPresent = map.containsKey(val);
        if (!isPresent) map.put(val, new LinkedHashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !isPresent;
    }
    
    public boolean remove(int val) {
        boolean isPresent = map.containsKey(val);
        if (!isPresent) return false;

        // Returns the first element in linkedhashset (first inserted loc of val): O(1)
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);

        // Swap this loc with last element in list
        if (loc < list.size() - 1) {
            int valInLastLoc = list.get(list.size() - 1);
            list.set(loc, valInLastLoc);
            map.get(valInLastLoc).remove(list.size() - 1);
            map.get(valInLastLoc).add(loc);
        }
        list.remove(list.size() - 1);

        // If last entry of val is removed, remove val from map
        if (map.get(val).isEmpty()) map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get( rand.nextInt(list.size()) );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

