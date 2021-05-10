package sorting_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
 * Write a method to sort an array ot strings so that all tne anagrnms are next to
each other.
 */

class AnagramComparator implements Comparator<String> {
	
	public String sortChars(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
}

public class GroupAnagrams {	
	public static String[] groupAnagrams(String[] array) {
		Arrays.sort(array, new AnagramComparator());
		return array;
	}

	public static String[] groupAnagramsHashMap(String[] array) {
		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		// Insert sorted string into hashmap (anagrams will have same key)
		for(String s: array) {
			String key = sortChars(s);
			if (!hm.containsKey(key)) {
				hm.put(key, new ArrayList<String>());
			}
			hm.get(key).add(s);
		}
		
		// Convert hash table into array
		int idx = 0;
		for(String key: hm.keySet()) {
			for(String s: hm.get(key)) {
				array[idx++] = s;
			}
		}
		
		return array;
	}
	
	public static String sortChars(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	
	public static void main(String[] args) {
		String[] array = {"abc", "def", "azy", "cba", "ghi", "bac"};
		//String[] sortedArray = groupAnagrams(array);
		String[] sortedArray = groupAnagramsHashMap(array);
		System.out.println(Arrays.toString(sortedArray));
	}
}
