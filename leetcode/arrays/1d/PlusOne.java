/*
66. Plus One
Easy
Topics
Companies
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.
*/

import java.util.*;

class PlusOne {
    private static int[] plusOne(int[] digits) {
    	for(int i=digits.length-1; i>=0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }

    public static void main(String[] args) {
    	int[] nums = {4,3,2,1};
    	int[] arr = plusOne(nums);
    	for(int i: arr) System.out.print(i + " ");
    }
}