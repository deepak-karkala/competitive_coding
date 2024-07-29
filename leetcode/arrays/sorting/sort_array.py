"""
912. Sort an Array
Solved
Medium
Topics
Companies
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
"""


class SortArray:
    def sortArray(self, nums: List[int]) -> List[int]:
        def merge(arr, l, m, r):
            left, right = arr[l : m + 1], arr[m + 1 : r + 1]
            i, j, k = 0, 0, l

            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    arr[k] = left[i]
                    i += 1
                else:
                    arr[k] = right[j]
                    j += 1
                k += 1

            while i < len(left):
                arr[k] = left[i]
                i += 1
                k += 1

            while j < len(right):
                arr[k] = right[j]
                j += 1
                k += 1

            return arr

        def mergeSort(arr, left, right):
            if left == right:
                return arr
            mid = (left + right) // 2

            mergeSort(arr, left, mid)
            mergeSort(arr, mid + 1, right)
            merge(arr, left, mid, right)
            return arr

        return mergeSort(nums, 0, len(nums) - 1)
