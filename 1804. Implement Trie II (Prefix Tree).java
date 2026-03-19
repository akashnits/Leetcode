class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) 
                return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) 
                return 0;
            curr = curr.children[c - 'a'];
        }
        return curr.prefixCount;
    }

    public void erase(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr = curr.children[c - 'a'];
            curr.prefixCount--;
        }
        curr.wordCount--;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int prefixCount = 0;
        int wordCount = 0;
    }
}
