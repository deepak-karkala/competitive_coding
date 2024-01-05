/*
1295. Find Numbers with Even Number of Digits
Easy
Topics
Companies
Hint
Given an array nums of integers, return how many of them contain an even number of digits
*/

class NumbersEvenDigits {
    private static int findNumbers(int[] nums) {
        int count = 0;
        for(int num: nums) {
        	if (countDigits(num) % 2 == 0) count++;
        }
        return count;
    }

    private static int countDigits(int num){
    	int numDigits = 0;
    	while(num > 0) {
    		num /= 10;
    		numDigits++;
    	}
    	return numDigits;
    }

    public static void main(String[] args) {
    	int[] nums = {12,345,2,6,7896};
    	System.out.println(findNumbers(nums));
    }
}