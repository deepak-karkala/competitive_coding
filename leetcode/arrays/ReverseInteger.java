public class ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;
        int newrev = 0;
        while (x != 0) {
            newrev = rev*10 + x%10;
            // Check overflow
            if ((newrev - x%10)/10 != rev) return 0;
            rev = newrev;
            x = (int) x/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
