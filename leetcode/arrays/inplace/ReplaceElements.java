/*
1299. Replace Elements with Greatest Element on Right Side
Easy
Topics
Companies
Hint
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array
*/


class ReplaceElements {
	// Array inplace
    private static int[] replaceElements(int[] arr) {
        int currMax = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for(int i = arr.length - 2; i >= 0; i--) {
        	int currNum = arr[i];
        	arr[i] = currMax;
        	currMax = Math.max(currMax, currNum);
        }
        return arr;
    }

    public static void main(String[] args) {
    	int[] arr = {17,18,5,4,6,1};
    	int[] rep = replaceElements(arr);
    	for(int i: rep) System.out.print(i + " ");
    }
}