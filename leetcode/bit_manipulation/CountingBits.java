import java.util.Arrays;

/*
 * Counting Bits
Easy
8.3K
397
Given an integer n, return an array ans of length n + 1 such that
for each i (0 <= i <= n), ans[i] is the number of 1's in the binary
representation of i.
 */

public class CountingBits {
    public static int[] countingBits_bruteforce(int n) {
        int[] nbits = new int[n+1];

        for(int i=1; i<=n; i++) {
            int num = i;
            while (num!=0){
                nbits[i] += num & 1;
                num = num >> 1;
            }
        }

        return nbits;
    }

    public static void main(String[] args) {
        int[] nums = countingBits_bruteforce(5);
        System.out.println(Arrays.toString(nums));
    }
}
