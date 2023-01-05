package arrays_strings;

public class OneAway {
    
    public static boolean oneAway(String str1, String str2) {
        // Return false if lengths mismatch by more than 1
        if ( Math.abs(str1.length() - str2.length()) > 1 ) return false;

        // s1 -> Shorter string s2 -> Longer string
        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;

        int index1=0;
        int index2 = 0;
        boolean foundDifference = false;
        while ((index1<s1.length()) && (index2<s2.length())) {

            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) return false;
                foundDifference = true;

                if (s1.length() == s2.length()) index1++;
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "balf"));
    }
}
