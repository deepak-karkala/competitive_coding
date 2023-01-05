package arrays_strings;

public class PalindromePermutation {
    
    // Approach 1
    // Get character counts (int[] of character size: assume - 128/256)
    // Check if at most one is odd
    public static boolean palindromePermutation(String s) {
        int[] chcount = new int[128]; // Assume 128
        int countOdd = 0;

        for(char ch: s.toCharArray()) {
            int val = Character.getNumericValue(ch) - Character.getNumericValue('a');
            chcount[val]++;

            if ((chcount[val] % 2)==1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }
        return countOdd <=1;
    }

    // Approach 2
    // Bit vector (number of bits = character size(26)=>32 bits or 4 bytes or 1 int)
    // As we see each character keep toggling the bit position
    // At the end, if all bits are 0 or at most 1 bit is set to 1, then it can be a palindrome
    public static boolean palindromePermutationbv(String s) {
        int bitvector = 0;

        for(char ch: s.toCharArray()) {
            int val = Character.getNumericValue(ch) - Character.getNumericValue('a');
            //bitvector ^=  (1<<val);
            bitvector = toggleBit(bitvector, val);
        }
        return (bitvector==0 || isOneBitSet(bitvector));
    }

    public static int toggleBit(int bitvector, int index) {
        //return bitvector^(1<<index);
        int mask = 1<<index;
        if ((bitvector & mask)==0) {
            bitvector |= mask;
        } else {
            bitvector &= ~mask;
        }
        return bitvector;
    }

    public static boolean isOneBitSet(int bitvector) {
        return ((bitvector & (bitvector-1))==0);
    }

    public static void main(String[] args) {
        System.out.println(palindromePermutationbv("ababecc"));
    }
}
