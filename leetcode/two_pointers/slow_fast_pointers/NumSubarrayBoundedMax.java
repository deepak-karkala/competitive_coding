/*
795. Number of Subarrays with Bounded Maximum
Medium
Topics
Companies
Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

The test cases are generated so that the answer will fit in a 32-bit integer.
*/


class NumSubarrayBoundedMax {
    private static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int j=0,count=0,res=0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=left && nums[i]<=right){
                res+=i-j+1;count=i-j+1;
            }
            else if(nums[i]<left){
                res+=count;
            }
            else{
                j=i+1;
                count=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	int[] nums = {2,9,2,5,6};
    	int left = 2, right = 8;
    	System.out.println(numSubarrayBoundedMax(nums, left, right));
    }
}