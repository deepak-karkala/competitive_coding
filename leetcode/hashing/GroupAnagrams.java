/*
49. Group Anagrams
Medium
14.5K
422
Companies
Given an array of strings strs, group the anagrams together.
You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
*/
import java.util.*;

public class GroupAnagrams {
	private static List<List<String>> groupAnagramsBaseline(String[] strs){
		List<List<String>> subsets = new ArrayList<List<String>>();
		List<String> subset = new ArrayList<String>();
		List<HashMap> list = new ArrayList<HashMap>();

		for(String str: strs) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for(char ch: str.toCharArray()) {
				if (map.containsKey(ch)) map.put(ch, map.get(ch)+1);
				else map.put(ch, 1);
			}
			list.add(map);
		}

		boolean[] used = new boolean[strs.length];
		for(int i=0; i<strs.length; i++) {
			if (!used[i]) {
				subset = new ArrayList<String>();
				subset.add(strs[i]);
				used[i] = true;
				for(int j=i+1; j<strs.length; j++) {
					if (!used[j] && list.get(i).equals(list.get(j))) {
						subset.add(strs[j]);
						used[j] = true;
					}
				}
				subsets.add(new ArrayList<>(subset));
			}
		}
		return subsets;
	}

	private static List<List<String>> groupAnagramsHashing(String[] strs) {
		if (strs==null || strs.length==0) return new ArrayList<List<String>>();

		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		char[] chcount = new char[26]; // letters come from lowercase alphabets alone

		for(String str: strs){
			chcount = new char[26];
			for(char c: str.toCharArray()) chcount[c-'a']++;
			String keystr = String.valueOf(chcount);
			if(!map.containsKey(keystr)) map.put(keystr, new ArrayList<String>());
			map.get(keystr).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagramsHashing(strs));
	}
}