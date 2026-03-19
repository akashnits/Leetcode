class Solution {
    public int countDistinct(String s) {
        Trie trie= new Trie();
        int n = s.length();
        int res = 0;
        for(int i=0; i < n; i++){
            res += trie.insert(s.substring(i));
        }
        return res;
    }

    class Trie{
        TrieNode root = new TrieNode();

        // in trie, whenever we insert a new node - it resprensets a distinct substring
        int insert(String word){
            TrieNode curr = root;
            int count = 0;
            for(char c: word.toCharArray()){
                if(curr.children[c-'a'] == null){
                    count++;
                    curr.children[c-'a'] = new TrieNode();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
            return count;
        }
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
}
