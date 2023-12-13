/*
424. Longest Repeating Character Replacement
Medium
Topics
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations
*/

class CharacterReplacement {
	/*
	Approach: Sliding window
	Time: O(n) Space:O(1)
	*/
    private static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0, maxLen = 0, maxCount = 0, currLen = 0;

        for(int end=0; end<s.length(); end++) {
        	maxCount = Math.max(maxCount, ++count[s.charAt(end)-'A']);

        	// Window becomes invalid when
        	//		numberOfDistinctCharactersWhichCanBeFlipped > k
        	//		=> substringLen - maxCount > k
        	currLen = end - start + 1;

        	while(currLen - maxCount > k) {
        		count[s.charAt(start)-'A']--;
        		start++;
        		currLen = end-start+1;
        	}

        	maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
    	String s = "AABABBA";
    	int k = 1;
    	System.out.println(characterReplacement(s, k));
    }
}