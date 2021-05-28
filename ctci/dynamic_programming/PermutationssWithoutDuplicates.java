package dynamic_programming;

import java.util.ArrayList;

/*
 * Permutations without Dups: 
 * Write a method to compute all permutations of a 
 * string of unique characters. 
 */

public class PermutationssWithoutDuplicates {
	
	/*
	 * Using permutations of first n-1, 
		generate all permutations with nth character
		Insert nth character at each position
	 */
	public static ArrayList<String> getPermsTop(String s) {
		if (s == null) return null;
		if (s == "") return new ArrayList<String>();
		return getPerms(s);
	}

	public static ArrayList<String> getPerms(String s) {
		ArrayList<String> allPerms = new ArrayList<String>();
		int len = s.length();

		// Base case
		if (len == 1) {
			allPerms.add(s);
			return allPerms;
		}
		
		// Recursive call
		ArrayList<String> perms = getPerms(s.substring(0, len-1));
		
		// Using permutations of first n-1, 
		// generate all permutations with nth character
		// Insert nth character at each position
		char ch = s.charAt(len-1);
		for(String substr: perms) {
			for(int i = 0; i < len; i++) {
				
				String newPerm = substr.substring(0, i) + 
						ch + 
						substr.substring(i, substr.length());
				
				allPerms.add(newPerm);
			}
		}
		return allPerms;	
	}
	
	
	/*
	 * Using permutations of length n-1, 
		generate all permutations of length n
		Example: "abc"
		Length 1: a, b, c
		Length 2: ab, ac, ba, bc, ca, cb
		Length 3: abc, acb, bac, bca, cab, cba
		To each substring, append each character at the end 
	 */
	public static ArrayList<String> getPermsLen(String s) {
		if (s == null) return null;
		if (s == "") return new ArrayList<String>();
		return getPermsLen(s, s.length());
	}
	
	public static ArrayList<String> getPermsLen(String s, int len) {
		ArrayList<String> allPerms = new ArrayList<String>();
		
		// Base case
		if (len == 1) {
			for(int i = 0; i < s.length(); i++) {
				allPerms.add(String.valueOf(s.charAt(i)));
			}
			return allPerms;
		}
		
		// Recursive call
		ArrayList<String> perms = getPermsLen(s, len-1);
		
		// To each substring, append each character at the end
		for(String str: perms) {
			for(int i = 0; i < s.length(); i++) {
				
				String ch = String.valueOf(s.charAt(i));
				
				if (!str.contains(ch))
					allPerms.add(str + ch);
				
			}
		}
		return allPerms;
	}
	
	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> perms = getPermsLen(str);
		System.out.println(perms);
	}
}
