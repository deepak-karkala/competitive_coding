/*
503. Next Greater Element II
Solved
Medium
Topics
Companies
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
*/

class NextGreaterElementsII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n * 2; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i % n])
                nge[stack.pop()] = nums[i % n];
            stack.push(i % n);
        }
        return nge;
    }
}