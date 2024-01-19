/*
1431. Kids With the Greatest Number of Candies
Easy
Topics
Companies
Hint
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.

Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.
*/

import java.util.*;

class KidsWithCandies {
    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>(candies.length);

        int maxCandies = 0;
        for(int c: candies) maxCandies = Math.max(maxCandies, c);

        maxCandies -= extraCandies;
        for(int c: candies) {
        	list.add(c >= maxCandies);
        }
        /*
        for(int c: candies) {
        	if (c + extraCandies >= maxCandies) list.add(true);
        	else list.add(false);
        }*/
        return list;
    }

    public static void main(String[] args) {
    	int[] candies = {2,3,5,1,3};
    	int extraCandies = 3;
    	List<Boolean> list = kidsWithCandies(candies, extraCandies);
    	for(boolean b: list) System.out.print(b + " ");
    }
}