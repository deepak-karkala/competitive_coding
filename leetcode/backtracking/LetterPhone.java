/*
17. Letter Combinations of a Phone Number
Medium
14.2K
820
Companies
Given a string containing digits from 2-9 inclusive, return all possible letter combinations
that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that
1 does not map to any letters.
*/

import java.util.*;

public class LetterPhone {
	private static List<String> letterPhoneBacktrack(String digits) {
		if (digits.length() == 0 || digits ==null) return new ArrayList<String>();
		List<String> subsets = new ArrayList<String>();
		backtrack(subsets, "", digits, 0);
		return subsets;
	}

	private static void backtrack(List<String> subsets, String str, String digits, int index){
		if (index == digits.length()) {
			subsets.add(str);
		} else {

			// Digit to letter mapping
			char digit = digits.charAt(index);
			String letters = "";
			if (digit == '2') {
				letters = "abc";
			} else if (digit == '3') {
				letters = "def";
			} else if (digit == '4') {
				letters = "ghi";
			} else if (digit == '5') {
				letters = "jkl";
			} else if (digit == '6') {
				letters = "mno";
			} else if (digit == '7') {
				letters = "pqrs";
			} else if (digit == '8') {
				letters = "tuv";
			} else if (digit == '9') {
				letters = "wxyz";
			}

			// Recurse for next digit (all letter combinations)
			for(int i=0; i<letters.length(); i++) {
				backtrack(subsets, str+letters.charAt(i), digits, index+1);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(letterPhoneBacktrack("23"));
	}
}