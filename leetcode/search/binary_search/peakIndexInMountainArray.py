"""
852. Peak Index in a Mountain Array
Solved
Medium
Topics
Companies
You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

Return the index of the peak element.

Your task is to solve it in O(log(n)) time complexity.
"""


class PeakIndexInMountainArray:
    def peakIndexInMountainArray(self, arr: List[int]) -> int:
        low, high = 0, len(arr) - 1

        while low <= high:
            mid = low + (high - low) // 2

            if 0 < mid < len(arr):
                if arr[mid - 1] < arr[mid] > arr[mid + 1]:
                    return mid
                elif arr[mid - 1] < arr[mid] < arr[mid + 1]:
                    low = mid + 1
                else:
                    high = mid - 1
            elif mid == 0:
                low = mid + 1
            else:
                high = mid - 1
