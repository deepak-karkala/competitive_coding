/*
1089. Duplicate Zeros
Easy
Topics
Companies
Hint
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything
*/

class DuplicateZeros {
	// Array: inplace
	//	Use read and write pointers to make inplace operations
    private static int[] duplicateZeros(int[] arr) {
    	int numZeroes = 0;
    	for(int i=0; i<arr.length; i++) {
    		if (arr[i] == 0) numZeroes++;
    	}

    	// Setting read pointer appropriately
    	int writePtr = arr.length + numZeroes - 1;
        int readPtr = arr.length - 1;

        while(readPtr >= 0 && readPtr < writePtr) {

            // Copy current element
            if (writePtr < arr.length) arr[writePtr] = arr[readPtr];

            // If current element is 0, decrement twice since 0 needs to be written twice
            if (arr[readPtr] == 0) {
                writePtr--;
                if (writePtr < arr.length) arr[writePtr] = arr[readPtr];
            }
            
            readPtr--;
            writePtr--;
        }

        return arr;
    }

    public static void main(String[] args) {
    	int[] arr = {1,0,2,3,0,4,5,0};	// 0 0 1 7 6 0 0 2
    	arr = duplicateZeros(arr);
    	for(int i: arr) System.out.print(i + " ");
    }
}