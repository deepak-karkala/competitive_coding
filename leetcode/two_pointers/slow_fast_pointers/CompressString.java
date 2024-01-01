/*
443. String Compression
Medium
Topics
Companies
Hint
Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
*/

class CompressString {
	/*
	Approach: 2 pointers, fast and slow
	Time: O(n) Space: O(1)
	*/
    private static int compress(char[] chars) {
    	int slow = 0, fast = 0;

    	while(fast < chars.length) {
    		char currentChar = chars[fast];
    		int count = 0;

    		while(fast < chars.length && chars[fast] == currentChar) {
    			fast++;
    			count++;
    		}

    		chars[slow++] = currentChar;
    		if (count > 1) {
    			for(char ch: Integer.toString(count).toCharArray()) chars[slow++] = ch;
    		}
    	}

    	return slow;
    }

    public static void main(String[] args) {
    	char[] chars = {'a','a','a','b','b','a','a'};
    	System.out.println(compress(chars));
    }
}