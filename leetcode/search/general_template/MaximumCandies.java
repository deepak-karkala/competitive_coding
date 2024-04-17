/*
2226. Maximum Candies Allocated to K Children
Solved
Medium
Topics
Companies
Hint
You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.

You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can take at most one pile of candies and some piles of candies may go unused.

Return the maximum number of candies each child can get.
*/

class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        for(int c: candies) if (c > maxCandies) maxCandies = c;
        int low = 0, high = maxCandies;

        while(low < high) {
            int mid = (low + high + 1) / 2;
            if (feasible(candies, k, mid)) low = mid;
            else high = mid - 1;
        }
        return low;
    }

    public boolean feasible(int[] candies, long k, int mid) {
        long numChildren = 0;
        for(int c: candies) numChildren += c / mid;
        return numChildren >= k;
    }
}