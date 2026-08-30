class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();

        TreeSet<String> set = new TreeSet<>((a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);

            if (fa != fb) return fb - fa; // hotter first
            return a.compareTo(b); // ASCII - smallest first
        });
    }

    TrieNode root = new TrieNode();
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
            return new ArrayList<>();
        }


        // treat a normal char - we go ahead and search for hottest three
        sb.append(c);

        TrieNode node = root;
        

        for (char ch : sb.toString().toCharArray()) {
            node = node.children.get(ch);

            if (node == null)
                return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();

        for (String s : node.set) {
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
