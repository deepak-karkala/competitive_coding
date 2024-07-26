"""
1299. Replace Elements with Greatest Element on Right Side
Solved
Easy
Topics
Companies
Hint
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.
"""


class ReplaceElements:
    def replaceElements(self, arr: List[int]) -> List[int]:
        maxRight = -1

        for i in range(len(arr) - 1, -1, -1):
            curr = arr[i]
            arr[i] = maxRight
            maxRight = max(maxRight, curr)

        return arr
