/*
2390. Removing Stars From a String
Solved
Medium
Topics
Companies
Hint
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

Note:

The input will be generated such that the operation is always possible.
It can be shown that the resulting string will always be unique.
 

Example 1:

Input: s = "leet**cod*e"
Output: "lecoe"
*/

class RemoveStars {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()) {
            if (ch == '*') sb.deleteCharAt(sb.length() - 1);
            else sb.append(ch);
        }

        return sb.toString();
    }
}