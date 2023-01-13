public class ValidPalindromePermutation {
    
    public static boolean validPalindromePermutation(String s) {
        if (s==null || s.length()==0) return false;
        if (s.length()<=2) return true;

        int countOdd = 0;
        int[] chcount = new int[26]; // Assuming lowercase characters only
        // Get character counts
        for(int i=0; i<s.length(); i++) {
            chcount[s.charAt(i) - 'a']++;
        }

        // Count number of odds
        for(int i=0; i<chcount.length; i++) {
            if (chcount[i]%2==1) countOdd++;
        }

        return countOdd <= 2;
    }

    public static void main(String[] args) {
        System.out.println(validPalindromePermutation("baab"));
    } 
}
