"""
14. Longest Common Prefix
Solved
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
"""


class LongestCommonPrefix:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        # Iterate through prefixes from first string
        for i in range(len(strs[0])):
            # Compare it with all the strings, if mismatch return
            for s in strs:
                if i == len(s) or s[i] != strs[0][i]:
                    return strs[0][:i]

        return strs[0]
