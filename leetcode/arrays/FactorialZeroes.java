public class FactorialZeroes {
    public static int factorialZeroes(int n){
        int count = 0;

        while(n > 0){
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        int numTrailingZeroes = factorialZeroes(12);
        System.out.println(numTrailingZeroes);
    }
}