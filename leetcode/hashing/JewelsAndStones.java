/*
771. Jewels and Stones
Easy
Topics
Companies
Hint
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/

import java.util.*;

class JewelsAndStones {
    private static int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for(char c: jewels.toCharArray()) set.add(c);

        for(char c: stones.toCharArray())
        	if (set.contains(c)) count++;

        return count;
    }

    public static void main(String[] args) {
    	String jewels = "aA", stones = "aAAbbbb";
    	System.out.println(numJewelsInStones(jewels, stones));
    }
}