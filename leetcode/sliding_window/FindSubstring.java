/*
30. Substring with Concatenation of All Words
Hard
Topics
Companies
You are given a string s and an array of strings words. All the strings of words are of the same length.

A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.

For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.
*/
import java.util.*;

class FindSubstring {
	/*
	Approach: Sliding window and match 2 hashmaps
		1. Count frequency of words in words array using hash map
			(Irrespective of permutation, number of times each 
			word occurs remains same when concatenated)
		2. Split String s into chunks of words.length * words[0].length
			(Number of words * Length of each word = length of substring to search in s)
		3. Create hashmap of number of occurrences of words in each chunk
		4. Check if the two hashmaps are equal, if yes record the start index
			(Check if number of occurrences of words are similar in two hashmaps)
	Time: O() Space: O()
	*/
    private static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		int lenS = s.length();
		int numWords =  words.length;
		int lenWord = words[0].length();

		if (s == null || s.length()==0 || words==null || words.length==0) return list;

		Map<String, Integer> map1 = new HashMap<>();
		for(String word: words)
			map1.put(word, map1.getOrDefault(word, 0) + 1);

		for(int i=0; i<lenS-numWords*lenWord+1; i++) {
			String substring = s.substring(i, i+numWords*lenWord);
			if (isSubStringPresent(substring, map1, lenWord))
				list.add(i);
		}
		return list;
    }

    private static boolean isSubStringPresent(String str, Map<String,Integer> map1, int lenWord) {
		Map<String, Integer> map2 = new HashMap<>();

    	for(int i=0; i<str.length(); i+=lenWord) {
    		String substr = str.substring(i, i+lenWord);
			map2.put(substr, map2.getOrDefault(substr, 0) + 1);
    	}
    	return map1.equals(map2);
    }


    public static void main(String[] args) {
    	String s = "barfoofoobarthefoobarman";
    	String[] words = {"bar","foo","the"};
    	List<Integer> list = findSubstring(s, words);
    	for(Integer i: list)
    		System.out.println(i);
    }
}