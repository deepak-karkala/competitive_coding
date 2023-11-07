/*
599. Minimum Index Sum of Two Lists
Easy
Topics
Companies
Given two arrays of strings list1 and list2, find the common strings with the least index sum.

A common string is a string that appeared in both list1 and list2.

A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.

Return all the common strings with the least index sum. Return the answer in any order.
*/
import java.util.*;

class MinimumIndexSum {
	/*
		1. Map all strings in list1 to indices
		2. While iterate through list2
			Get index of current string, if null, continue
			If not null, and sum of current index and index from list1 <= minIndexSum
				Add current string to result
				If sum strictly less, then clear the old results
	*/
    private static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<list1.length; i++) map.put(list1[i], i);

        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<String>();
        
        for(int i=0; i<list2.length; i++) {
        	Integer j = map.get(list2[i]);

        	if (j != null && i+j <= minSum) {
        		if (i+j < minSum) { res.clear(); minSum = i+j;}
        		res.add(list2[i]);
        	}
        }
        
        return res.toArray(new String[res.size()]);
        //String[] arr = new String[res.size()];
        //for(int i=0; i<res.size(); i++) arr[i] = res.get(i);
        //return arr;
    }

    public static void main(String[] args) {
    	String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
    	String[] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
    	String[] arr = findRestaurant(list1, list2);
    	for(String s: arr) System.out.println(s);
    }
}

