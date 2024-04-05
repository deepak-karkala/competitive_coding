/*
50. Pow(x, n)
Solved
Medium
Topics
Companies
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*/

class MyPow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            x = 1 / x;
            return (n % 2 == 0) ? myPow(x * x, -(n/2)) : x * myPow(x * x, -(n/2));
        }
        return (n % 2 == 0) ? myPow(x * x, n/2) : x * myPow(x * x, n/2);
    }
}