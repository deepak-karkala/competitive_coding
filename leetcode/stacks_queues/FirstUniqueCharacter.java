/*
387. First Unique Character in a String
Easy
7.4K
250
Given a string s, find the first non-repeating character in it and
return its index. If it does not exist, return -1.
*/

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

	public static void main(String[] args) {
		System.out.println(firstUniqueCharacter2("aabb"));
	}
}