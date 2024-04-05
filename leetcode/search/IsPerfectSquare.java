/*
367. Valid Perfect Square
Easy
Topics
Companies
Given a positive integer num, return true if num is a perfect square or false otherwise.
*/

class IsPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long low = 1, high = num;

        while(low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid == num) return true;

            if (mid > num / mid) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}