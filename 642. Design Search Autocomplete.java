class AutocompleteSystem {
//     Normal char: O(1) average — move one trie level + read first 3.
// On #: O(L log N) — remove + reinsert sentence across L prefix nodes.
// Build: O(T log N) where T = total characters across all sentences.
// Space: O(T).

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

        TreeSet<String> set = new TreeSet<>((a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);

            if (fa != fb) return fb - fa; // hotter first
            return a.compareTo(b); // ASCII - smallest first
        });
    }

    TrieNode root = new TrieNode();

    // keep track of current prefix node instead of starting from root every time
    TrieNode currNode = root;

    Map<String, Integer> freq = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            freq.put(sentences[i], times[i]);
            add(sentences[i]);
        }
    }

    public List<String> input(char c) {

        // end of sentence - we update all nodes which fall on this path
        if (c == '#') {
            String s = sb.toString();

            remove(s);
            freq.put(s, freq.getOrDefault(s, 0) + 1);
            add(s);

            sb.setLength(0);

            // reset current node for next input sentence
            currNode = root;

            return new ArrayList<>();
        }


        // treat a normal char - we go ahead and search for hottest three
        sb.append(c);

        // just move one step ahead from current prefix node
        if (currNode != null)
            currNode = currNode.children.get(c);

        if (currNode == null)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();

        for (String s : currNode.set) {
            res.add(s);
            if (res.size() == 3) break;
        }

        return res;
    }

    void add(String s) {
        TrieNode node = root;

        for (char c : s.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            node.set.add(s); // we add the sentence to each node TreeSet
        }
    }

    // we remove all treeset on trie path containing string
    void remove(String s) {
        if (!freq.containsKey(s)) return;

        TrieNode node = root;

        for (char c : s.toCharArray()) {
            node = node.children.get(c);
            node.set.remove(s);
        }
    }
}
