/*
344. Reverse String
Easy
Topics
Companies
Hint
Write a function that reverses a string. The input string is given as an
array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory
*/


class ReverseString {
    private static void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;

        while (low < high) {
        	char tmp = s[high];
        	s[high] = s[low];
        	s[low] = tmp;
        	low++;
        	high--;
        }
    }

    public static void main(String[] args) {
    	char[] s = {'h','e','l','n', 'l','o'};
    	reverseString(s);
    	System.out.println(s);
    }
}