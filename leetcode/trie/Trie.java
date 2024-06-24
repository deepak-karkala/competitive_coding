/*
208. Implement Trie (Prefix Tree)
Solved
Medium
Topics
Companies
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
*/

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch: prefix.toCharArray()) {
            if (node.children[ch - 'a'] == null) return false;
            node = node.children[ch - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */