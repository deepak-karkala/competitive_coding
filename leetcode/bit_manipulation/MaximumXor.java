import java.util.HashSet;

/*
 * 421. Maximum XOR of Two Numbers in an Array
Medium
4.7K
350
Given an integer array nums, return the maximum result of
nums[i] XOR nums[j], where 0 <= i <= j < n.

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
 */
public class MaximumXor {

    public static int maximumXor(int[] nums) {
        int maxXor = 0;
        int mask = 0;

        //For each bit position from MSB
        for(int i=31; i>=0; i--) {

            //Mask: 100...000 -> 1100...0000 --> 1110...0000 -> ... -> 1111...111
            mask = mask | (1 << i); 

            HashSet<Integer> set = new HashSet<Integer>();
            //Store MSBs till ith position of each element
            for(int num: nums) {
                int leftPartOfNum = num & mask;
                set.add(leftPartOfNum);
            }

            //Brute force- for each leftPartOfNum, search in rest of array
            //Optimise - for each leftPartOfNum, see if 1 is possible in ith position (greedy solution)
            //  <-> a^b=c => a^c=b
            // For each a, instead of iterating through array to find b such that a ^ b = c
            //      assuming c with 1 at ith position, search for b in set => O(1) search time
            int greedyTry = maxXor | (1 << i);
            for(int leftPartOfNum: set) {
                int pairWithMSBMismatch = leftPartOfNum ^ greedyTry;
                if (set.contains(pairWithMSBMismatch)) {
                    maxXor = greedyTry;
                    break;
                }
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(maximumXor(nums));
    }
}
