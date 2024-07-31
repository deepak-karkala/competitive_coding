"""
1189. Maximum Number of Balloons
Solved
Easy
Topics
Companies
Hint
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.
"""


class MaxNumberOfBalloons:
    def maxNumberOfBalloons(self, text: str) -> int:
        key = "balloon"
        count = {}
        charr = list(text)
        for c in charr:
            if c in key:
                count[c] = count.get(c, 0) + 1

        countBalloon = {}
        charr = list(key)
        for c in charr:
            countBalloon[c] = countBalloon.get(c, 0) + 1

        ans = inf
        for c in countBalloon:
            if c in count:
                ans = min(ans, count[c] // countBalloon[c])
            else:
                return 0
        return ans

    def maxNumberOfBalloons2(self, text: str) -> int:
        count = Counter(text)
        countBalloon = Counter("balloon")

        res = float("inf")
        for c in countBalloon:
            res = min(res, count[c] // countBalloon[c])
        return res
