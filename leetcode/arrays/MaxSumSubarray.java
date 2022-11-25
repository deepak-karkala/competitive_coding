/*
 * Given two words word1 and word2, find the minimum number of
 * operations required to convert word1 to word2. You have the
 * following 3 operations permitted on a word:
	Insert a character
	Delete a character
	Replace a character 
 */

class MaxSumSubarray {
    public int maxSumSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIdx = 0;
        int endIdx = 0;
        for(int i=0; i<nums.length; i++){
            /*
            sum += nums[i];
            if (sum > max) {
                max = sum;
                endIdx = i;
            }
            if (sum < 0) {
                sum = 0;
                startIdx = i+1;
            }
            */
            
            //sum = Math.max(nums[i], sum+nums[i]);
            //max = Math.max(sum, max);
            if (sum+nums[i] < nums[i]) {
                sum = nums[i];
                startIdx = i;
            } else {
                sum += nums[i];
            }

            if (sum > max) {
                max = sum;
                endIdx = i;
            }
        }
        System.out.println(startIdx);
        System.out.println(endIdx);
        return max;
    }
    
    public static void main(String[] args) {
    	int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = {-2, -1, -3};
        MaxSumSubarray ms = new MaxSumSubarray();
    	int max = ms.maxSumSubarray(nums);
    	System.out.println(max);
    }
}
