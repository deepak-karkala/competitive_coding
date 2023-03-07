/*
Longest Substring - at most K distinct characters
*/

public class LongestSubstringKdistinct {

	private static String longestSubstringKdistinct(String s, int k) {
		int[] map = new int[128];
		int start=0, end=0, maxStart=0, maxLen=0, counter=0;

		while(end < s.length()) {
			char c1 = s.charAt(end);
			if(map[c1]==0) counter++;
			map[c1]++;
			end++;

			while(counter > k){
				char c2 = s.charAt(start);
				map[c2]--;
				if(map[c2]==0) counter--;
				start++;
			}

			if (maxLen < end-start) {
				maxLen = end-start;
				maxStart = start;
			}
		}
		return maxLen==0 ? "" : s.substring(maxStart, maxStart+maxLen);
	}

	public static void main(String[] args){
		System.out.println(longestSubstringKdistinct("gaaabbcdefffffabcmk", 4));
	}
}