"""
443. String Compression
Solved
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
"""


class StringCompress:
    def compress(self, chars: List[str]) -> int:
        writePos, readPos = 0, 0
        anchor = 0

        for readPos, char in enumerate(chars):
            if readPos == len(chars) - 1 or char != chars[readPos + 1]:
                chars[writePos] = char
                writePos += 1

                if readPos > anchor:
                    numReps = readPos - anchor + 1

                    for ch in str(numReps):
                        chars[writePos] = ch
                        writePos += 1

                anchor = readPos + 1

        return writePos
