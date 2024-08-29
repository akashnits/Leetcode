import java.util.*;
import java.util.stream.Collectors;

class AutocompleteSystem {
    PrefixTrie pTrie;
    Map<String, Integer> map;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        pTrie = new PrefixTrie();
        map = new HashMap<>();
        sb = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            int freq = times[i];
            map.put(sentence, freq);
            pTrie.insert(sentence, freq);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            // End of input; process and reset
            String sentence = sb.toString();
            map.put(sentence, map.getOrDefault(sentence, 0) + 1);
            pTrie.insert(sentence, map.get(sentence));
            sb.setLength(0); // Reset StringBuilder
            return new ArrayList<>();
        } else {
            // Update current prefix and get suggestions
            sb.append(c);
            String prefix = sb.toString();
            Map<String, Integer> suggestionsMap = pTrie.searchPrefix(prefix);

            // Use a PriorityQueue to get the top 3 suggestions
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> {
                    // Compare by frequency in descending order
                    int freqCompare = Integer.compare(e2.getValue(), e1.getValue());
                    if (freqCompare == 0) {
                        // Compare lexicographically if frequencies are the same
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return freqCompare;
                }
            );

            // Add all entries to the priority queue
            for (Map.Entry<String, Integer> entry : suggestionsMap.entrySet()) {
                pq.offer(entry);
            }

            // Collect the top 3 results from the priority queue
            List<String> result = new ArrayList<>();
            while (!pq.isEmpty() && result.size() < 3) {
                result.add(pq.poll().getKey());
            }

            return result;
        }
    }
}

class PrefixTrie{
    TrieNode root;
    PrefixTrie(){
        this.root = new TrieNode();
    }
    
    void insert(String sentence, int freq){
        TrieNode node = root;
        // loop over all chars
        for(char c: sentence.toCharArray()){
            if(node.children.get(c) == null){
                // insert this char
                node.children.put(c, new TrieNode());
            }
            node.children.get(c).sentenceFreqMap.put(sentence, freq);
            node = node.children.get(c);
        }
    }
    
    Map<String, Integer> searchPrefix(String prefix){
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.children.get(c) == null){
                return new HashMap();
            }
            node = node.children.get(c);
        }
        return node.sentenceFreqMap;
    }
    
    boolean searchSentence(String sentence){
        TrieNode node = root;
        for(char c: sentence.toCharArray()){
            if(node.children.get(c) == null){
                return false;
            }
            node = node.children.get(c);
        }
        return node.end.equals("#");
    }
    
}

class TrieNode{
    Map<Character, TrieNode> children;
    String end = "#";
    Map<String, Integer> sentenceFreqMap;

    // PriorityQueue<Pair<String, Integer>> minHeap = new PriorityQueue<>((pair1, pair2) -> 
    // (pair1.getKey().length() == pair2.getKey().length()) ? 
    // String.compare(pair2.getKey() , pair1.getKey()) : (pair1.getValue() - pair2.getValue())));
    
    TrieNode(){
        this.children = new HashMap();
        this.sentenceFreqMap = new HashMap();
    }
}
