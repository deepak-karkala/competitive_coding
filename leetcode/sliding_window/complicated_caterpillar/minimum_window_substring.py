"""
76. Minimum Window Substring
Solved
Hard
Topics
Companies
Hint
Given two strings s and t of lengths m and n respectively, return the minimum window 
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique
"""


class MinimumWindowSubstring:
    def minWindow(self, s: str, t: str) -> str:
        count = Counter(t)
        numCharsOfTinWin = 0
        left = 0
        minLen, minStartIdx = float(inf), 0

        for right in range(len(s)):
            # Increment numChar if this char is in t
            if count[s[right]] > 0:
                numCharsOfTinWin += 1
            # Decrement count of current char
            #   1. If there in t, it will go +ve to 0
            #   2. If not there in t, it will go from 0 to -ve
            count[s[right]] -= 1

            # Window is valid as long as all the chars in t have appeared in window
            while numCharsOfTinWin == len(t):
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    minStartIdx = left

                # Remove char at left pointer from window
                count[s[left]] += 1
                # If this char is one of the char in t, then update numChar
                if count[s[left]] > 0:
                    numCharsOfTinWin -= 1
                left += 1

        return "" if minLen == float(inf) else s[minStartIdx : minStartIdx + minLen]
