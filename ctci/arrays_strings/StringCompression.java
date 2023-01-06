package arrays_strings;

/*
 *  Implement a method to perform basic string compression using the
 *  counts of repeated characters. For example, the string aabcccccaaa 
 *  would become a2blc5a3. If the "compressed" string would not become 
 *  smaller than the original string, your method should return the 
 *  original string. You can assume the string has only uppercase
 *  and lowercase letters (a - z).
 */

public class StringCompression {

    /*
     * Go through string, keep track of current character count
        Whenever next character is not same as current
        Append - current character and character count
        Reset character count = 0
     */
    public static String stringCompression(String s) {
        StringBuilder cmpstr = new StringBuilder();
        int chcount = 0;

        for(int i=0; i<s.length(); i++) {
            chcount++;
            if ( (i+1==s.length()) || (s.charAt(i+1) != s.charAt(i))) {
                cmpstr.append(s.charAt(i));
                cmpstr.append(chcount);
                chcount = 0;
            }
        }

        return cmpstr.length() > s.length() ? s : cmpstr.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(stringCompression("abcd"));
    }
}
