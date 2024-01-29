/*
509. Fibonacci Number - Easy
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
*/

class Fibonacci {
    public int fib(int n) {
        int a = 0, b = 1;
        if (n <= 1) return n;
        int sum = 0;
        for(int i=2; i<=n; i++){
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}