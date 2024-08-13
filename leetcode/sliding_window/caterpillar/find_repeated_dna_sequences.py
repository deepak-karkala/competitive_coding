"""
187. Repeated DNA Sequences
Solved
Medium
Topics
Companies
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.
"""


class RepeatedDnaSequences:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        res = set()
        hset = set()
        k = 10

        for i in range(len(s) - (k - 1)):
            segment = s[i : i + k]
            if segment in hset:
                res.add(segment)
            hset.add(segment)

        return list(res)
