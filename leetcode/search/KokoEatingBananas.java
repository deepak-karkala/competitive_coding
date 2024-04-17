/*
875. Koko Eating Bananas
Solved
Medium
Topics
Companies
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.
*/

class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p: piles) if (p > max) max = p;
        int low = 1, high = max;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (feasible(piles, h, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public boolean feasible(int[] piles, int h, int speed) {
        int totalHours = 0;
        for(int p: piles) {
            //totalHours += (p - 1) / speed + 1;
            totalHours += p/speed;
            if (p % speed != 0) totalHours++;
        }
        return totalHours <= h;
    }
}