class StreamChecker {
    StringBuilder queryStr;
    PrefixTrie prefixTrie;
    int maxLength = 0;
    public StreamChecker(String[] words) {
        prefixTrie = new PrefixTrie();
        // build a trie with the words
        for(String word: words){
            prefixTrie.insert(new StringBuilder(word).reverse().toString());
            maxLength = Math.max(maxLength, word.length());
        }

        queryStr = new StringBuilder();
    }
    
    public boolean query(char letter) {
        queryStr.insert(0, letter);
        if(queryStr.length() > maxLength){
            queryStr.setLength(maxLength);
        }
        // pass the whole queryStr reversed to find a word in the trie 
        return prefixTrie.query(queryStr.toString());
    }

    class PrefixTrie{
        TrieNode root;

        PrefixTrie(){
            root = new TrieNode();
        }

        // insert word 
        void insert(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.isEnd = true;
        }

        // query 
        boolean query(String word){
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null){
                    return false;
                }else{
                    node = node.children[c-'a'];
                    // check if this is a valid word i.e. isEnd = true
                    if(node.isEnd){
                        return true;
                    }
                }
            }
            return node.isEnd;
        }

    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
