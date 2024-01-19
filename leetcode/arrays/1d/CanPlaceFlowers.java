/*
605. Can Place Flowers
Easy
Topics
Companies
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
*/

class CanPlaceFlowers {
    private static boolean canPlaceFlowers(int[] flowerbed, int n) {
    	if (n == 0) return true;

    	// Conditions when flower can be placed
    	// flowerbed[i] == 0 &&
    	//		flowerbed[i-1]==0 && flowerbed[i+1]==0
    	// To avoid out of index exception,
    	// 		If i==0, flowerbed[i-1] should not be checked
    	// 		If i==len-1, flowerbed[i+1] should not be checked
        for(int i=0; i<flowerbed.length; i++) {
        	if ( flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0) ) {
        		n--;
        		flowerbed[i] = 1;
        	}
        	if (n == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] flowerbed = {1,0,0,0,1};
    	int n = 2;
    	System.out.println(canPlaceFlowers(flowerbed, n));
    }
}