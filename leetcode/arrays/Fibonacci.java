public class Fibonacci {
    public static int fib(int n) {
        int fn2 = 0;
        int fn1 = 1;
        int fn = fn1 + fn2;

        if (n==0) return fn2;
        if (n==1) return fn1;

        for(int i=2; i<=n; i++) {
            fn = fn1 + fn2;
            fn2 = fn1;
            fn1 = fn;
        }
        return fn;
    }

    public static long fib_topdown(int A) {
        long[] fib = new long[A+1];
        fib[0] = 0;
        fib[1] = 1;
        return fib_recurse(A, fib);
    }
    
    public static long fib_recurse(int n, long[] fib) {
        if (fib[n] > 0) return fib[n];

        if (n == 0) return 0;
        if (n == 1) return 1;

        fib[n] = fib_recurse(n-1, fib) + fib_recurse(n-2, fib);
        return fib[n];
    }
    public static void main(String[] args){
        System.out.println(fib_topdown(50));
    }
}
