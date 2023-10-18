/*
509. Fibonacci Number
Solved
Easy
Topics
Companies
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci
sequence, such that each number is the sum of the two preceding ones, starting from
0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

 

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
*/
import java.util.*;

class Fibonacci {
    private static int fib(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        fib_recursive(n, memo);
        return memo[n];
    }

    private static int fib_recursive(int n, int[] memo) {
    	if (memo[n] != -1) return memo[n];

    	if (n <= 1) {
    		memo[n] = n;
    		return n;
    	}
    	memo[n] = fib_recursive(n-1, memo) + fib_recursive(n-2, memo);
    	return memo[n];
    }

    public static void main(String[] args) {
    	System.out.println(fib(4));
    }
}