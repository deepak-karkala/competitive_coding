"""
424. Longest Repeating Character Replacement
Solved
Medium
Topics
Companies
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.
"""


class CharacterReplacement:
	"""
	How to create longest balanced s within any sliding window ?
	Intuition:
		For window length = winLen
		Count freq (number of occurrences) of each char
		Find the max such freq (let this freq be maxFreq and char be maxChar)
		Longest balanced string (entire string of same char) can be made
			by changing all other characters to maxChar
		Number of such changes required = winLen - maxFreq
	If this number is less than k,
		then it is a valid window, update the maxLen
	If not, update left pointer, this will reduce the window,
		now repeat and see if the condition is satisfied
	"""
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        maxLen = 0
        count = defaultdict(int)

        for right in range(len(s)):
            count[s[right]] += 1
            """
            maxFreq: max(count.values())
            winLen: right - left + 1
            numChanges: winLen - maxFreq
            """
            while (right - left + 1) - max(count.values()) > k:
                count[s[left]] -= 1
                left += 1

            maxLen = max(maxLen, right - left + 1)

        return maxLen
