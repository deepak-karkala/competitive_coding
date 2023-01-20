/*
 * Container With Most Water
Medium
22.3K
1.2K
You are given an integer array height of length n. There are n vertical lines
drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the
container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
In this case, the max area of water (blue section) the container can contain is 49.
 */

public class ContainerWater {
    public static int containerWater(int[] height) {
        int max = 0;
        //int curr = 0;
        int i=0, j=height.length-1;

        while(i < j) {
            //curr = (j-i) * Math.min(height[i], height[j]);
            //if (curr > max) max = curr;
            max = Math.max(max, (j-i) * Math.min(height[i], height[j]));

            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWater(height));
    }    
}
