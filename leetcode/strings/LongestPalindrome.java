/*
 * Given a string s, return the longest palindromic substring in s.
 ***** Process
 * Brute force
For every start-end pair O(N^2), check if palindrome O(N) => O(N^3)
Hint
If smaller substring is known to be palindrome, how to check if surrounding larger substring
 is also a palindrome => if i to j is a palindrome then check if str(i-1)==str(j+1) 
 then i-1 to j+1 is a palindrome
What I couldn’t crack ?
Reduce palindrome check time from O(N)
What indices to search and track the palindromes ?

***** Approach
Palindrome check time cannot be reduced it is still O(N)
Instead of checking palindromes with start-end pairs, check if palindrome exists with 
indices as middle point. Two scenarios
For (i = 1:n) => Time reduced from O(N^2)  to O(N)
Either there is a palindrome with centre i => Odd length
Or there is a palindrome with centre str(i)=str(i+1) => Even length
So check if palindromes are centred around above two cases and try to extend the palindromes. 
Track the longest palindrome using 
Either start index and length (global variables or use class or use array and pass by reference)
Or return the current palindrome as string. If current length > max length, update max length and 
the longest palindrome. (return type String, no global variable)
 */



 public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String max = "";
        if (s.length() < 2) return s;

        // Iterate through length and see if a palindrome is centred on either
        // substring(i, i) or substring(i,i+1)
        for(int i=0; i<s.length(); i++) {
            String s1 = extendPalindrome(s, i, i); // Odd length
            String s2 = extendPalindrome(s, i, i+1); // Even length
            
            int currMax = Math.max(s1.length(), s2.length());

            // Update longest palindrome if current length > max length
            if (max.length() < currMax) max = s1.length() > s2.length() ? s1 : s2;
        }
        return max;
    }
    
    public static String extendPalindrome(String s, int startIdx, int endIdx) {
        while ( (startIdx >= 0) && (endIdx < s.length()) && (s.charAt(startIdx) == s.charAt(endIdx)) ) {
            startIdx--;
            endIdx++;
        }
        return s.substring(startIdx+1, endIdx);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
