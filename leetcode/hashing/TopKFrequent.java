/*
347. Top K Frequent Elements
Medium
Topics
Companies
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.
*/
import java.util.*;

class TopKFrequent {
	/*
		Approach 1: HashMap + Array of ArrayList
		Get map of numbers to number of occurrence
		Use array, 
			index -> number of occurrence,
			entry -> numbers which have occurred index number of times
		Keep filling result from array starting from highest index
			(characters which have occurred most number of times)
		Time: O(n) Space: O(n)
	*/
    private static int[] topKFrequent(int[] nums, int k) {
        int[] res;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Get map of count of occurrences
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        /*
        	Use array, 
			index -> number of occurrence,
			entry -> numbers which have occurred index number of times
		*/
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	int freq = entry.getValue();
        	if (bucket[freq] == null) bucket[freq] = new ArrayList<>();
        	bucket[freq].add(entry.getKey());
        }

        /*
        	Keep filling result from array starting from highest index
			(characters which have occurred most number of times)
		*/
        for(int i = bucket.length-1; list.size()<k; i--) {
        	if (bucket[i] != null) list.addAll(bucket[i]);
        }
        
        res = new int[list.size()];
        for(int i=0; i<list.size(); i++) res[i] = list.get(i);
        return res;
        //return list.toArray(new int[list.size()]);
    }


    /*
    	Approach: HashMap + Priority Queue
    	Get map of count of occurrences
    	Use PQ to sort in order of frequency
    	Time: O(nlogn) Space: O(n)
    */
    private static int[] topKFrequent2(int[] nums, int k) {
    	int[] res;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
        	new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));

        // Get map of count of occurrences
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	maxHeap.offer(entry);
        }

        while(list.size() < k) {
        	Map.Entry<Integer, Integer> entry = maxHeap.poll();
        	list.add(entry.getKey());
        }

        res = new int[list.size()];
        for(int i=0; i<list.size(); i++) res[i] = list.get(i);
        return res;
    }


    /*
    	Approach: HashMap + TreeMap (stores entries in natural order or custom comparator)
    	Get map of count of occurrences
    	Use TreeMap to sort list of integers in order of frequency
    	Time: O(nlogn) Space: O(n)
    */
    private static int[] topKFrequent3(int[] nums, int k) {
    	int[] res;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();

        // Get map of count of occurrences
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	int freq = entry.getValue();
        	if (!treemap.containsKey(freq))
        		treemap.put(freq, new ArrayList<>());
        	treemap.get(freq).add(entry.getKey());
        }

        while(list.size() < k) {
        	Map.Entry<Integer, List<Integer>> entry = treemap.pollLastEntry();
        	list.addAll(entry.getValue());
        }

        res = new int[list.size()];
        for(int i=0; i<list.size(); i++) res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,1,2,2,3}; int k = 2;
    	int[] res = topKFrequent3(nums, k);
    	for(int i: res) System.out.print(i + " ");
    }
}