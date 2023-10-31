/*
202. Happy Number
Easy
Topics
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a
cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
*/
import java.util.*;

class HappyNumber {
	/* Using HashSet */
    private static boolean isHappy(int n) {
        int sumSquare = 0;
        HashSet<Integer> hset = new HashSet<>();

        while (hset.add(n)) {
        	while (n > 0) {
        		sumSquare += Math.pow(n%10, 2);
        		n /= 10;
        	}
        	n = sumSquare;
        	sumSquare = 0;

        	if (n == 1) return true;
        }
        return false;
    }

    /* Floyd cycle detection algorithm 
    (similar to Linked list cycle detection) */
    private static boolean isHappyCycleDetect(int n) {
    	int slow = n, fast = n;
    	do {
    		slow = getSumSquare(slow);
    		fast = getSumSquare(fast);
    		fast = getSumSquare(fast);
    	} while (slow != fast);

    	if (slow == 1) return true;
    	return false;
    }

    private static int getSumSquare(int n) {
    	int sumSquare = 0;
    	while (n > 0) {
    		sumSquare += (n%10) * (n%10);
    		n /= 10;
    	}
    	return sumSquare;
    }

    public static void main (String[] args) {
    	int n = 19;
    	System.out.println(isHappyCycleDetect(n));
    }
}