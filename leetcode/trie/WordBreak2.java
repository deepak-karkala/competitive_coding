/*
140. Word Break II
Solved
Hard
Topics
Companies
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
*/

class WordBreak2 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return wordBreak(s, wordDict, map);
    }

    public List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> map) {
        List<String> res = new ArrayList<String>();
        // Base case
        if (s == null || s.length() == 0) return res;

        // Return memoised solution
        if (map.containsKey(s)) return map.get(s);

        // If entire substring is present in dictionary
        if (wordDict.contains(s)) res.add(s);

        // Check for each cut in s
        for(int i = 0; i < s.length(); i++) {
            String postfix = s.substring(i);
            if (wordDict.contains(postfix)) {
                List<String> sentences = wordBreak(s.substring(0, i), wordDict, map);
                for(String sentence: sentences)
                    res.add(sentence + " " + postfix);
            }
        }

        // Add result to memo
        map.put(s, res);
        return res;
    }

    public List<String> wordBreak1(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return wordBreak(s, wordDict, map);
    }

    public List<String> wordBreak1(String s, List<String> wordDict, Map<String, List<String>> map) {
        List<String> res = new ArrayList<String>();

        // Return memoised solution
        if (map.containsKey(s)) return map.get(s);

        // Check for each word in dictionary
        for(String word: wordDict) {
            // Check if given string starts with this word
            if (s.startsWith(word)) {
                String rem = s.substring(word.length());
                // If entire word is present, add it to result
                if (rem.length() == 0) res.add(word);
                else {
                    List<String> sentences = wordBreak(rem, wordDict, map);
                    for(String sentence: sentences)
                        res.add(word + " " + sentence);
                }
            }
        }

        // Add result to memo
        map.put(s, res);
        return res;
    }
}