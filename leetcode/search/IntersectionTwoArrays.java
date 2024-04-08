/*
349. Intersection of Two Arrays
Solved
Easy
Topics
Companies
Given two integer arrays nums1 and nums2, return an array of their 
intersection
. Each element in the result must be unique and you may return the result in any order.
*/

class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<Integer>();
        Arrays.sort(nums1);

        for(int i=0; i<nums2.length; i++) {
            if (binarySearch(nums1, nums2[i])) list.add(nums2[i]);
        }

        int[] arr = new int[list.size()];
        int idx = 0;
        for(Integer i: list) {
            arr[idx++] = i;
        }
        return arr;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (target == nums[mid]) return true;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}