/*
274. H-Index
Medium
Topics
Companies
Hint
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
*/

class HIndex {
    private static int hIndex(int[] citations) {
    	// Array:
    	//		Index:number of citations
    	//		Value:Number of papers with index number of citations
        int[] count = new int[citations.length + 1];

        // Count number of papers with each number(index) of citations 
        for(int i=0; i<citations.length; i++) {
        	if(citations[i] > citations.length) count[citations.length]++;
        	else count[citations[i]]++;
        }

        // Start from last, check if that index has value > index
        //		=> Number of papers with citations idx > number of citations idx
        int total = 0;
        for(int i=citations.length; i>=0; i--) {
        	total += count[i];
        	if (total >= i) return i;
        }

        return 0;
    }

    public static void main(String[] args) {
    	int[] arr = {3,0,6,1,5};
    	System.out.println(hIndex(arr));
    }
}