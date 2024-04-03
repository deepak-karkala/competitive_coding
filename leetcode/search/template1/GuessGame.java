/*
374. Guess Number Higher or Lower
Solved
Easy
Topics
Companies
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.
*/

public class GuessGame  {
    public int guessNumber(int n) {
        int low = 1, high = n;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) low = mid + 1;
            else high = mid -1;
        }
        return -1;
    }
}