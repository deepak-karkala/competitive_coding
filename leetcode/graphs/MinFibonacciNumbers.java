/*
1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K
Medium
955
60
Companies
Given an integer k, return the minimum number of Fibonacci numbers whose sum is equal to k.
The same Fibonacci number can be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 for n > 2.
It is guaranteed that for the given constraints we can always find such Fibonacci numbers that sum up to k.
*/

import java.util.*;

class MinFibonacciNumbers {
    private static int findMinFibonacciNumbers(int k) {
        int a=1, b=1;
        while(b <= k) {
        	int fib = a + b;
        	a = b;
        	b = fib;
        }

        int count = 0;
        while(k != 0) {
        	if (b <= k) {
        		k -= b;
        		count++;
        	}
        	int fib = b;
        	b = a;
        	a = fib - b;
        }
        return count;
    }

    public static void main(String[] args) {
    	int num = findMinFibonacciNumbers(7);
    	System.out.println(num);
    }
}