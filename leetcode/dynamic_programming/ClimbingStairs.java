/*
70. Climbing Stairs
Easy
18.1K
566
Companies
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/


class ClimbingStairs {

	private static int climbStairs(int n) {
		int[] count = new int[n+1];
		climbStairsMemo(n, count);
		return count[n];
	}

	private static int climbStairsMemo(int n, int[] count) {
		if (n <= 2) count[n] = n;
		if (count[n] != 0) {
			return count[n];
		} else {
			count[n] = climbStairsMemo(n-1, count) + climbStairsMemo(n-2, count);
		}
		return count[n];
	}

	private static int climbStairsBottomUp1(int n) {
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;

		for(int i=2; i<=n; i++) {
			count[i] = count[i-1] + count[i-2];
		}
		return count[n];
	}

	private static int climbStairsBottomUp2(int n) {
		int one_step_before = 1;
		int two_step_before = 1;
		int count = one_step_before;

		for(int i=2; i<=n; i++) {
			count = one_step_before + two_step_before;
			two_step_before = one_step_before;
			one_step_before = count;			
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(climbStairsBottomUp2(4));
    }
}
