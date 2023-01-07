/*
 * Given two strings needle and haystack, return the index of the first
 * occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

 public class Strstr {
    public static int strStr(String haystack, String needle) {
        //if (needle.length() > haystack.length()) return false;
        int index1 = 0;
        int index2 = 0;
        int substrlen = needle.length();
        int startMatchIndex = 0;

        while(index1 < haystack.length()) {
            if (haystack.charAt(index1)==needle.charAt(index2)) {
                if (index2 == 0) startMatchIndex = index1;
                index1++;
                index2++;
                if (index2 == substrlen) return index1 - substrlen;
            } else {
                if (index2 != 0) {
                    index1 = startMatchIndex+1;
                } else {
                    index1++;
                }
                index2 = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abcdef", "cde"));
    }
}
