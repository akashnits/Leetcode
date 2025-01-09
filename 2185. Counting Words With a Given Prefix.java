class Solution {
    public int prefixCount(String[] words, String pref) {
        // create prefix trie
        Trie pTrie = new Trie();
        for(String word: words){
            pTrie.insert(word, pref,  pref.length());
        }

        return pTrie.searchPrefix(pref);
    }


    class Trie{
        TrieNode root;

        Trie(){
            root = new TrieNode();
        }

        void insert(String word, String pref, int len){
            TrieNode node = root;
            int idx = 0;
            for(char c: word.toCharArray()){
                if(idx == len){
                    break; // early exit
                }
                // don't insert if c not equals char at idx
                if(c != pref.charAt(idx)){
                    break;
                }
                if(node.children[c-'a'] == null){
                    TrieNode newNode = new TrieNode();
                    node.children[c-'a'] = newNode;
                }
                // we have seen this, increment counter
                node = node.children[c-'a'];
                node.counter++;
                idx++;
            }

        }

        int searchPrefix(String pref){
            TrieNode node = root;
            for(char c: pref.toCharArray()){
                if(node.children[c-'a'] == null){
                    return 0; // couldn't find pref
                }
                node = node.children[c-'a'];
            }
            return node.counter;
        }
    }

    class TrieNode{
        TrieNode[] children;
        int counter;

        TrieNode(){
            this.children = new TrieNode[26];
            this.counter = 0;
        }
    }
}
