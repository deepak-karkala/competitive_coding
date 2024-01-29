/*
172. Factorial Trailing Zeroes
Medium
Given an integer n, return the number of trailing zeroes in n!.
*/

class TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}