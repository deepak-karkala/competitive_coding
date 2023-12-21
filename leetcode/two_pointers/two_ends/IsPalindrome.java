/*
125. Valid Palindrome
Easy
Topics
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
*/

class IsPalindrome {
	/*
	Approach: 2 pointers from two ends
	Time: O(n) Space:O(1)
	*/
    private static boolean isPalindrome(String s) {
    	if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;

        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);

        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) return false;
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }

    public static void main(String[] args) {
    	String s = "A man, a plan, a canal: PanamA";
    	System.out.println(isPalindrome(s));
    }
}