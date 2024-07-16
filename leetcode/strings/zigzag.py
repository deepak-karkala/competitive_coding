"""
6. Zigzag Conversion
Solved
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
"""


class Zigzag(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if numRows == 1 or numRows >= len(s):
            return s

        rows = [[""] for _ in range(numRows)]
        idx = 0  # Index into s
        direction = -1  # 1:Down, -1:Up

        for c in s:
            rows[idx].append(c)
            if idx == 0 or idx == numRows - 1:
                direction = -direction
            idx += direction

        return "".join("".join(row) for row in rows)
