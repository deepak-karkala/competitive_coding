"""
744. Find Smallest Letter Greater Than Target
Solved
Easy
Topics
Companies
Hint
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.


"""


class NextGreatestLetter:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left, right = 0, len(letters)

        while left < right:
            mid = left + (right - left) // 2

            if letters[mid] > target:
                right = mid
            else:  # letters[mid] <= target:
                left = mid + 1

        return letters[left % len(letters)]
        # return letters[0] if left == len(letters) else letters[left]
