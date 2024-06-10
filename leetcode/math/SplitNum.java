/*
2578. Split With Minimum Sum
Solved
Easy
Topics
Companies
Hint
Given a positive integer num, split it into two non-negative integers num1 and num2 such that:

The concatenation of num1 and num2 is a permutation of num.
In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
num1 and num2 can contain leading zeros.
Return the minimum possible sum of num1 and num2.

Notes:

It is guaranteed that num does not contain any leading zeros.
The order of occurrence of the digits in num1 and num2 may differ from the order of occurrence of num.
*/

class SplitNum {
    public int splitNum(int num) {
        String str = num + "";
        char[] charr = str.toCharArray();
        Arrays.sort(charr);

        int num1 = 0, num2 = 0;
        for(int i = 0; i < charr.length; i++) {
            if (i % 2 == 0) num1 = num1 * 10 + (charr[i] - '0');
            else num2 = num2 * 10 + (charr[i] - '0');
        }

        return num1 + num2;
    }
}