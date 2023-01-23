/*
 * Reverse Bits
Easy
4.1K
1K
Reverse bits of a given 32 bits unsigned integer.
 */

public class ReverseBits {

    public static int reverseBits(int n) {
        int rev = 0;

        for(int i=0; i<32; i++) {
            int bit = (n & 1);
            n = n >>> 1;
            rev = rev | (bit << (31-i));
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }
}
