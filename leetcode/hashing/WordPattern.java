/*

Code

Testcase
Test Result
Test Result

290. Word Pattern
Easy
Topics
Companies
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter
in pattern and a non-empty word in s.
*/
import java.util.*;

class WordPattern {
    private static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hmap = new HashMap<>();
        HashSet<String> hset = new HashSet<String>();
        String[] str = s.split(" ");

        // REturn false if len of pattern and split string array mismatches
        if (pattern.length() != str.length) return false;

        for(int i=0; i<pattern.length(); i++) {
        	char c = pattern.charAt(i);
        	String string = str[i];
        	if (!hmap.containsKey(c)) {
        		if (!hset.add(string)) return false;
        		hmap.put(c, string);
        	} else {
        		if (!hmap.get(c).equals(string)) return false;
        	}
        }
        return true;
    }

    public static void main(String[] args) {
    	String pattern = "abba", s = "dog dog dog dog";
    	System.out.println(wordPattern(pattern, s));
    }
}