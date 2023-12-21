/*
42. Trapping Rain Water
Hard
Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/


class TrapWater {
	/*
	Approach: 2pointers from two ends
	Time: O(n) Space:O(1)
	*/
    private static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int totalWater = 0;

        while(left < right) {
        	if (height[left] <= height[right]) {
        		if (height[left] > maxLeft) maxLeft = height[left];
        		else totalWater += maxLeft - height[left];
        		left++;
        	} else {
        		if (height[right] > maxRight) maxRight = height[right];
        		else totalWater += maxRight - height[right];
        		right--;
        	}
        }
        return totalWater;
    }

    public static void main(String[] args) {
    	int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(trap(height));
    }
}