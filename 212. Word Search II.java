class Solution {
    Set<String> res = new HashSet();
    int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        // step 1: create a trie and add all the words which are to be searched
        Trie trie = new Trie();
        // insert all words
        for(String word: words){
            trie.insert(word);
        }

        // we do dfs from each cell and construct strings
        for(int i=0; i < board.length; i++){
            for(int j=0; j < board[0].length; j++){
                dfs(board, i, j, "", trie, new boolean[board.length][board[0].length]);
            }
        }
        return new ArrayList<String>(res);
    }

    void dfs(char[][] board, int row, int col, String word, Trie trie, boolean[][] visited){
        // check if out od bounds
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return;
        }

        // if not visited already
        if(visited[row][col]){
            return;
        }

        String newWord = word + board[row][col];
        if(!trie.startsWith(newWord)){
            return;
        }

        if(trie.search(newWord)){
            res.add(newWord);
        }

        // do something - mark as visited
        visited[row][col] = true;
        // recurse
        for(int[] dir: directions){
            dfs(board, row + dir[0], col + dir[1], newWord, trie, visited);
        }
        // undo
        visited[row][col] = false;
    }

    /* Implement a trie here */

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }
    
        public void insert(String word) {
            TrieNode currNode = root;
            for(int i=0; i < word.length(); i++){
                char c = word.charAt(i);
                if(currNode.children[c- 'a'] == null){
                    currNode.children[c- 'a'] = new TrieNode();
                }
                currNode = currNode.children[c-'a'];
            }
            currNode.endSymbol = '#';
        }
    
        public boolean search(String word) {
            TrieNode currNode = root;
            for(int i=0; i < word.length(); i++){
                char c = word.charAt(i);
                if(currNode.children[c- 'a'] == null){
                    return false;
                }
                currNode = currNode.children[c-'a'];
            }
            return currNode.endSymbol == '#';
        }
    
        public boolean startsWith(String prefix) {
            TrieNode currNode = root;
            for(int i=0; i < prefix.length(); i++){
                char c = prefix.charAt(i);
                if(currNode.children[c- 'a'] == null){
                    return false;
                }
                currNode = currNode.children[c-'a'];
            }
            return true;
        }

        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            char endSymbol;
        }
    }
}
