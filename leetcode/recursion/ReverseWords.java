/*
557. Reverse Words in a String III
Easy
Topics
Companies
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
*/

class ReverseWords {
    private static String reverseWords(String s) {
        int left = 0;
        int right = 0;
        char[] charr = s.toCharArray();

        while(left < s.length()) {
        	// Move the right pointer to next space
        	while(right<s.length() && charr[right] != ' ') right++;

        	charr = reversePartOfString(charr, left, right-1);

        	right++;
        	left = right;
        }

        return String.valueOf(charr);
    }

    private static char[] reversePartOfString(char[] charr, int low, int high) {
    	while(low < high) {
    		char tmp = charr[high];
    		charr[high] = charr[low];
    		charr[low] = tmp;
    		low++;
    		high--;
    	}
    	return charr;
    }

    public static void main(String[] args) {
    	String s = "Let's take LeetCode contest";
    	System.out.println(reverseWords(s));
    }
}