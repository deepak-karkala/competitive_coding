public class myPow {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0;
        if (n == 0) return 1;

        if (n < 0) {
            x = 1/x;
            return (n%2==0) ? myPow(x*x, -(n/2)) : x*myPow(x*x, -(n/2));
        }

        return (n%2==0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
