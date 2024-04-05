/*
744. Find Smallest Letter Greater Than Target
Solved
Easy
Topics
Companies
Hint
You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
*/

class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c: letters) {
            if (c - target > 0) return c;
        }
        return letters[0];
    }

    public char nextGreatestLetterBinarySearch(char[] letters, char target) {
        int n = a.length;

        //hi starts at 'n' rather than the usual 'n - 1'. 
        //It is because the terminal condition is 'lo < hi' and
        //  if hi starts from 'n - 1', 
        //we can never consider value at index 'n - 1'
        int lo = 0, hi = n;

        //Terminal condition is 'lo < hi', to avoid infinite loop
        //  when target is smaller than the first element
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x)     hi = mid;
            else    lo = mid + 1;                 //a[mid] <= x
        }
 
        //Because lo can end up pointing to index 'n', in which case
        //  we return the first element
        return a[lo % n];
    }
}