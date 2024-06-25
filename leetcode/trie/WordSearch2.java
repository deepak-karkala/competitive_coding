/*
212. Word Search II
Solved
Hard
Topics
Companies
Hint
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
*/

class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = buildTrie(words);

        for(int i = 0; i < board.length; i++) 
            for(int j = 0; j < board[0].length; j++)
                dfs(board, trie, res, i, j);

        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, Trie node, Set<String> res, int i, int j) {
        // Return (Stop backtracking) if
        //      Out of bounds, this letter is already used up,
        //      trie's next node is null (=> No words in dictionary with this prefix)
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
            board[i][j] == '#' || node.next[board[i][j] - 'a'] == null)
            return;
        
        // If there is a word that ends here, add it to result
        String wordEndingHere = node.next[board[i][j] - 'a'].word;
        if (wordEndingHere != null) res.add(wordEndingHere);

        // Go to next character in trie
        node = node.next[board[i][j] - 'a'];

        // Mark this character as already used
        char c = board[i][j];
        board[i][j] = '#';

        // Search in all 4 directions
        dfs(board, node, res, i + 1, j);
        dfs(board, node, res, i - 1, j);
        dfs(board, node, res, i, j + 1);
        dfs(board, node, res, i, j - 1);

        board[i][j] = c;
    }

    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            Trie p = root;
            for(char c: word.toCharArray()) {
                if (p.next[c - 'a'] == null) p.next[c - 'a'] = new Trie();
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String word = null;
    }
}