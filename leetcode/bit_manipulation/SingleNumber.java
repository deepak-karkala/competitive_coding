import java.util.ArrayList;
import java.util.List;

/*
 * Single Number
Easy
12.7K
487
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;

        for(int num: nums) result ^= num;
        return result;
    }

    public static int singleNumber_list(List<Integer> A) {
        int result = 0;

        for(int num: A) result ^= num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4,2,2,3,1};
        //System.out.println(singleNumber(nums));
        List<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(2);
        System.out.println(singleNumber_list(A));
    }
}
