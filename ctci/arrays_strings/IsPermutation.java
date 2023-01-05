package arrays_strings;

import java.util.Arrays;

public class IsPermutation {
    

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        //return isSameCharacters(countCharacters(s1), countCharacters(s2));
        return sort(s1).equals(sort(s2));
    }
    public static String sort(String s) {
        char[] charr = s.toCharArray();
        Arrays.sort(charr);
        return new String(charr);
    }

    public static boolean isSameCharacters(int[] count1, int[] count2) {
        for(int i=0; i<256; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }

    public static int[] countCharacters(String s) {
        int[] count = new int[256];
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)]++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "dbac";
        System.out.println(isPermutation(s1, s2));
    }
}
