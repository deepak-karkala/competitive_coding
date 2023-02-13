/*
387. First Unique Character in a String
Easy
7.4K
250
Given a string s, find the first non-repeating character in it and
return its index. If it does not exist, return -1.
*/
import java.util.*;

public class FirstUniqueCharacter {

	public static int firstUniqueCharacterBaseline(String s) {
		int[] num = new int[26]; // Assuming lowercase characters only
		int[] index = new int[26];
		int minIndex = s.length();

		for(char ch: s.toCharArray()) {
			num[ch - 'a']++;
			index[ch - 'a'] = s.indexOf(ch);
		}

		for(int i=0; i<num.length; i++) {
			if (num[i] == 1) {
				if (index[i] < minIndex) minIndex = index[i];
			}
		}
		return minIndex==s.length() ? -1 : minIndex;
	}

	public static int firstUniqueCharacter2(String s) {
		int[] num = new int[26]; // Assuming lowercase characters only

		for(char ch: s.toCharArray()) {
			num[ch - 'a']++;
		}

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (num[ch - 'a'] == 1) return i;
		}
		return -1;
	}

	/* Follow up - what if characters are coming in as a stream
	Solution - use LinkedHashMap
	Two pass solution won’t work here, store the incoming characters as they come in a
		Linked Hash-map in the order of occurrence. When it repeats, remove that particular
		character from Linked hash-map.
	At the end, return the first element. (That’s why Linked hash-map and not just hash-map
		since position is not possible in hash-map)
	*/
	public static int firstUniqueCharacterStream(String s) {
		Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (!set.contains(ch)) {
				set.add(ch);
				map.put(ch, i);
			} else {
				if(map.get(ch) != null) map.remove(ch);
			}
		}
		return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
	}

	public static void main(String[] args) {
		System.out.println(firstUniqueCharacterStream("loveleetcode"));
	}
}