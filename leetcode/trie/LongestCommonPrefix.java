/*
14. Longest Common Prefix
Solved
Easy
Topics
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
*/

class LongestCommonPrefix {
    // 0ms Beats 100%
    public String longestCommonPrefix(String[] strs) {
        int numStrings = strs.length;

        String prefix = strs[0];

        int i = 1;
        while(i < strs.length){
            while(!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() -1);
            i++;
        }
        return prefix;
    }
}