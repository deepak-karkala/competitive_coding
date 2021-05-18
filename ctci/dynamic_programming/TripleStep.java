package dynamic_programming;

/* 
 * A child is running up a staircase with n steps and can hop
 *  either 1 step, 2 steps, or 3 steps at a time. Implement a
 *   method to count how many possible ways the child can run up the stairs.
 */


public class TripleStep {
	
	public static int findNumWays(int n) {
		// Base cases
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		return findNumWays(n-1) + findNumWays(n-2) + findNumWays(n-3);
	}

	public static int findNumWaysTopDown(int n) {
		int[] memo = new int[n];
		return findNumWaysTopDown(n, memo);
	}
	
	public static int findNumWaysTopDown(int n, int[] memo) {
		// Base cases
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		if (memo[n-1] == 0) {
			memo[n-1] = findNumWaysTopDown(n-1, memo) + findNumWaysTopDown(n-2, memo) + 
					findNumWaysTopDown(n-3, memo);
		}
		return memo[n-1];
	}
	
	
	public static int findNumWaysBottomUp(int n) {
		int a = 1, b = 2, c = 4;
		
		// Base cases
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;		
		
		int numWays = 0;
		for(int i = 4; i <= n; i++) {
			numWays = a + b + c;
			a = b;
			b = c;
			c = numWays;
		}
		return numWays;
	}
	
	public static void main(String[] args) {
		//System.out.println(findNumWays(35));
		System.out.println(findNumWaysTopDown(35));
		//System.out.println(findNumWaysBottomUp(50));
	}
}