/*
784. Letter Case Permutation
Medium
Topics
Companies
Given a string s, you can transform every letter individually to be lowercase
or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in
any order
*/


import java.util.*;

class LetterCasePermutation {
	/*
	Approach: Backtracking 1
	*/
    private static List<String> letterCasePermutation(String s) {
    	List<String> list = new ArrayList<String>();
    	backtrack(s, 0, "", list);
        return list;
    }

    private static void backtrack(String s, int i, String str, List<String> list) {
    	if (i == s.length()) {
    		list.add(str);
    		return;
    	}

		char c = s.charAt(i);

		if (Character.isLetter(c)){
			str += Character.toLowerCase(c);
			backtrack(s, i+1, str, list);
			str = str.substring(0, str.length() - 1);

			str += Character.toUpperCase(c);
			backtrack(s, i+1, str, list);
			str = str.substring(0, str.length() - 1);
		} else {
			str += c;
			backtrack(s, i+1, str, list);
			str = str.substring(0, str.length() - 1);
		}
		return;
    }

    /*
	Approach: Backtracking (Minor improvements)
	*/
	private static List<String> letterCasePermutation2(String s) {
    	List<String> list = new ArrayList<String>();
    	backtrack2(s.toCharArray(), 0, list);
        return list;
    }
    private static void backtrack2(char[] chArr, int i, List<String> list) {
    	if (i == chArr.length) {
    		list.add(String.valueOf(chArr));
    		return;
    	}

		if (Character.isLetter(chArr[i])){
			chArr[i] = Character.toLowerCase(chArr[i]);
			backtrack2(chArr, i+1, list);

			chArr[i] = Character.toUpperCase(chArr[i]);
			backtrack2(chArr, i+1, list);
		} else {
			backtrack2(chArr, i+1, list);
		}
		return;
    }

    public static void main(String[] args) {
    	String s = "a1b2";
    	System.out.println(letterCasePermutation2(s));
    }
}