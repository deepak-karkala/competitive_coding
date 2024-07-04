/*
211. Design Add and Search Words Data Structure
Solved
Medium
Topics
Companies
Hint
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
*/

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            if (node.children[ch - 'a'] == null) node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] charr, int idx, TrieNode node) {
        // Base case
        if (idx == charr.length) return node.isWord;

        // If dot, go through all the non-null children
        if (charr[idx] == '.') {
            for(int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(charr, idx + 1, node.children[i]))
                    return true;
            }
        } else {
            return node.children[charr[idx] - 'a'] != null && match(charr, idx + 1, node.children[charr[idx] - 'a']);
        }

        return false;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */