class Solution {
    TrieNode root = new TrieNode();

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        // build trie
        for (String word : dictionary) {
            insert(word);
        }

        List<String> res = new ArrayList<>();

        for (String query : queries) {
            if (dfs(query, 0, root, 2)) {
                res.add(query);
            }
        }

        return res;
    }

    // insert into trie
    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    // dfs search with at most k edits
    private boolean dfs(String word, int index, TrieNode node, int editsLeft) {
        // prune
        if (editsLeft < 0) return false;

        // end condition
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // 1. match (no edit)
        if (node.children[c - 'a'] != null) {
            if (dfs(word, index + 1, node.children[c - 'a'], editsLeft)) {
                return true;
            }
        }

        // 2. replace (use edit)
        for (int i = 0; i < 26; i++) {
            if (i != (c - 'a') && node.children[i] != null) {
                if (dfs(word, index + 1, node.children[i], editsLeft - 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
}
