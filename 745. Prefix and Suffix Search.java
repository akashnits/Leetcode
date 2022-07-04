class WordFilter {
    Trie trie; 
    public WordFilter(String[] words) {
        trie = new Trie();
        // going to creater a suffix + # + word trie
        String specialChar = "#";
        for(int weight=0; weight < words.length; weight++){
            String word = words[weight];
            // for all suffixes of this word
            for(int i=0; i < word.length(); i++){
                String cusWord = word.substring(i) + specialChar + word;
                trie.insert(cusWord, weight);
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        // we search for prefix after # symbol
        // we search for suffix before # symbol
        
        // word to search - suffix + # + prefix
        
        String searchWord = suffix + "#" + prefix;
        
        // this word can occur more than once in trie
        
        return trie.search(searchWord);
    }
    
    
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap();
        int weight;
    }
    
    class Trie{
        TrieNode root;
        Character endSymbol = '*';
        
        Trie(){
            root = new TrieNode();
        }
        
        
        public void insert(String word, int weight){
            TrieNode node = root;
            for(int i=0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    node.children.put(c, new TrieNode());
                }
                node= node.children.get(c);
                // set the weight while inserting word in trie
                node.weight = weight;
            }
            node.children.put(endSymbol, null);
        }
        
        
        public int search(String word){
            // we only need to do prefix search
            TrieNode node = root;
            for(int i=0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!node.children.containsKey(c)){
                    return -1;
                }
                node = node.children.get(c);
            }
            //System.out.println("Yay, Found it!");
            return node.weight;
        } 
    }
}
