/*
69. Sqrt(x)
Solved
Easy
Topics
Companies
Hint
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python
*/

class MySqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1, high = x;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (mid <= x/mid && (mid+1) > x/(mid+1)) return mid;
            else if (mid > x/mid) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}