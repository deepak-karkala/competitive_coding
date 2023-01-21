import java.util.ArrayList;
import java.util.Arrays;

/*
 * Remove Duplicates from Sorted Array
Easy
9.8K
13.4K
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element
appears only once. The relative order of the elements should
be kept the same.
 */

 public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] nums){
        int i = 0, j = 0;

        while(i<nums.length) {
            if ( (i==0) || (nums[i]!=nums[i-1]) ) {
                nums[j++] = nums[i++];
            } else {
                i++;
            }
        }
        return nums;
    }

    public static ArrayList<Integer> removeDuplicates_list(ArrayList<Integer> a) {
        int i = 0, j = 0;
        int prev = a.get(0);
        for(Integer curr: a) {
            if ( (j==0) || (curr != prev) ) {
                a.set(j, a.get(i));
                j++;
                i++;
            } else {
                i++;
            }
            prev = curr;
        }

        return a;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        //nums = removeDuplicates(nums);
        //System.out.println(Arrays.toString(nums));

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(0);
        a.add(0);
        a.add(1);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(2);
        a = removeDuplicates_list(a);
        for(Integer el: a) {
            System.out.println(el);
        }

    }
}