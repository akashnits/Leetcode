class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        // build a trie - insert words
        Trie prefixTrie = new Trie();
        for(String product: products){
            prefixTrie.insert(product);
        }

        // create a list after each char is typed
        List<List<String>> suggestions = new ArrayList();
        for(int i=1; i <= searchWord.length(); i++){
            String prefix = searchWord.substring(0, i);
            TrieNode root = prefixTrie.searchPrefixNode(prefix);
            // we need find top 3 hits from the root
            List<String> levelSuggestions = new ArrayList();
            while(root != null && !root.pq.isEmpty()){
                levelSuggestions.add(0, root.pq.poll());
            }
            suggestions.add(levelSuggestions);
        }
        return suggestions;
    }


    // design trie and build a prefix trie
    class TrieNode{
        TrieNode[] children= new TrieNode[26];
        int k = 3;
        PriorityQueue<String> pq = new PriorityQueue<String>((a, b) -> b.compareTo(a));
        boolean isWordEnd;

        // we want to store top 3 hits
        public void addWordToPQ(String word){
            pq.offer(word);
            // check if size greated than 3, pop top
            if(pq.size() > k){
                pq.poll();
            }
        }
    }

    class Trie{
        TrieNode root = new TrieNode();

        void insert(String word){
            // loop over all chars 
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if(node.children[c-'a'] == null){
                    TrieNode newNode = new TrieNode();
                    node.children[c-'a'] = newNode;
                }
                node = node.children[c-'a'];
                // before moving to next node, add word to this node
                node.addWordToPQ(word);
            }
            node.isWordEnd= true;
        }

        boolean searchPrefix(String prefix){
            return searchPrefixNode(prefix) != null;
        }

        boolean searchWord(String word){
            TrieNode node = searchPrefixNode(word);
            return node != null && node.isWordEnd;
        }

        TrieNode searchPrefixNode(String prefix){
            TrieNode node = root;
            for(char c: prefix.toCharArray()){
                if(node.children[c-'a'] == null){
                    return null;
                }else{
                    node = node.children[c-'a'];
                }
            }
            return node;
        }
    }
}
