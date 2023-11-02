/*
1207. Unique Number of Occurrences
Easy
Topics
Companies
Hint
Given an array of integers arr, return true if the number of occurrences of each value
in the array is unique or false otherwise.
*/
import java.util.*;

class UniqueOccurrences {
    private static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i: arr)
        	hmap.put(i, hmap.getOrDefault(i, 0)+1);
        HashSet<Integer> hset = new HashSet<>(hmap.values());
        return hmap.size()==hset.size();
    }

    private static boolean uniqueOccurrences2(int[] arr) {
    	int[] count = new int[2001];

    	for(int num: arr)
    		count[num+1000]++;

    	Arrays.sort(count);
    	for(int i=0; i<count.length; i++)
    		if (i>0 && count[i]!=0 && count[i]==count[i-1]) return false;

    	return true;
    }

    public static void main(String[] args) {
    	int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
    	System.out.println(uniqueOccurrences2(arr));
    }
}