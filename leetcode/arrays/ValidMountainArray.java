/*
941. Valid Mountain Array
Easy
Topics
Companies
Hint
Given an array of integers arr, return true if and only if it is a valid mountain array.
*/

class ValidMountainArray {
    private static boolean validMountainArray(int[] arr) {
        boolean isDecrease = false, isIncrease = false;
        for(int i=0; i<arr.length; i++) {
        	if (i>0 && arr[i] == arr[i-1]) return false;
        	if (isDecrease && arr[i] > arr[i-1]) return false;
        	if (i>0 && arr[i] < arr[i-1]) isDecrease = true;
        	if (i>0 && arr[i] > arr[i-1]) isIncrease = true;
        }
        // To check for all increase or all decrease sequence
        if (!isDecrease || !isIncrease) return false;
        return true;
    }

    public static void main(String[] args) {
    	int[] arr = {0, 6, 3, 4, 5, 2, 1, 0};
    	System.out.println(validMountainArray(arr));
    }
}