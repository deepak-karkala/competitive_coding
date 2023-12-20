/*
167. Two Sum II - Input Array Is Sorted
Medium
Topics
Companies
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
*/

class TwoSumInputSorted {
	/*
	Approach: 2 pointers from two ends
	1. Start with 2 pointers at two ends
	2. When sum exceeds, decrement right pointer
	3. When sum is less than target, increment left pointer
	Time: O(n) Space: O(1)
	Can also use binary search for each position => Time: O(nlogn)
	*/
    private static int[] twoSum(int[] numbers, int target) {
    	int start = 0, end = numbers.length-1;
    	int[] res = new int[2];

    	while(start < end) {
    		if (numbers[start] + numbers[end] == target) {
    			res[0] = start + 1;
    			res[1] = end + 1;
    			return res;
    		} else if (numbers[start] + numbers[end] > target) {
    			end--;
    		} else {
    			start++;
    		}


    	}
        return res;
    }

    public static void main(String[] args) {
    	int[] numbers = {2,7,11,15};
    	int target = 9;
    	int[] res = twoSum(numbers, target);
    	for(int i: res) System.out.println(i);
    }
}