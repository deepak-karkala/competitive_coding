/*
1346. Check If N and Its Double Exist
Easy
Topics
Companies
Hint
Given an array arr of integers, check if there exist two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
*/

import java.util.*;

class CheckIfExist {
	// Hashset
    private static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int n: arr) {
        	if (set.contains(n*2)) return true;
            if (n%2==0 && set.contains(n/2)) return true;
        	set.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] arr = {10,2,5,3};
    	System.out.println(checkIfExist(arr));
    }
}