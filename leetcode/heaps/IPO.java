/*
502. IPO
Hard
Topics
Companies
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares
to Venture Capital, LeetCode would like to work on some projects to increase its capital
before the IPO. Since it has limited resources, it can only finish at most k distinct
projects before the IPO. Help LeetCode design the best way to maximize its total capital
after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit profits[i] and a minimum
capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will obtain its pure profit
and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize your final
capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.
*/
import java.util.*;

class IPO {
	/*
	Approach: Array + PQ
	1. Create pairs of profits and capital
	2. Sort this in increasing order of capital 
			(the project which requires least capital is most likely to be attempted first)
	3. Fill the PQ in ascending order of capital
			(PQ priority is defined by profits)
	4. Poll from PQ in descending order of profits
			(When there are multiple projects with more than required capital,
			choose the one which has highest profit)
	5. Keep updating capital until k projects are chosen
	Time: O(nlogn + klogn) Space: O(n)
	*/
    private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] pair = new int[capital.length][2];
        for(int i=0; i<capital.length; i++) pair[i] = new int[] {capital[i], profits[i]};
        Arrays.sort(pair, (a,b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a,b) -> b-a);
        int i = 0;
        while(k-- > 0) {
        	// Add all eligible projects (with more than required capital)
        	while(i<capital.length && pair[i][0] <= w) {
        		heap.offer(pair[i][1]);
        		i++;
        	}
        	if (heap.isEmpty()) break;
        	w += heap.poll();
        }
        return w;
    }

    public static void main(String[] args) {
    	int k = 2, w = 0;
    	int[] profits = {1,2,3};
    	int[] capital = {0,9,10};
    	System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}