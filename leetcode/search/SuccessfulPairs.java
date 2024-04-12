/*
2300. Successful Pairs of Spells and Potions
Solved
Medium
Topics
Companies
Hint
You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
*/

class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] pairs = new int[n];

        for(int i=0; i<n; i++) {
            int low = 0, high = m - 1;
            
            while(low <= high) {
                int mid = low + (high - low) / 2;
                long strength = (long) spells[i] * potions[mid];

                if (strength >= success) high = mid - 1;
                else low = mid + 1;
            }
            pairs[i] = m - low;
        }
        return pairs;
    }
}