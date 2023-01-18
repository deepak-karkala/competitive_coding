public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rint = 0;
        int rem = 0;
        int oint = x;
        while (x > 0) {
            rem = x % 10;
            x = (int) x / 10;
            rint = rint*10 + rem;
        }
        System.out.println(rint);
        return rint==oint;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(456654));
    }
}
