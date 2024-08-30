class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if(sentence1.length != sentence2.length){
            return false;
        }
        int n = sentence1.length;
        DSU dsu = new DSU(similarPairs);
        // treat similar pair as edges
        for(List<String> pair: similarPairs){
            String u = pair.get(0);
            String v = pair.get(1);

            // check if in the same set , else union it
            if(dsu.find(u) != dsu.find(v)){
                // union them
                dsu.union(u, v);
            }
        }

        // loop over sentences
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];

            if (word1.equals(word2)) {
                continue;
            }

            if (!dsu.parentMap.containsKey(word1)) {
                return false;
            }
            if (!dsu.parentMap.containsKey(word2)) {
                return false;
            }

            if (!dsu.find(word1).equals(dsu.find(word2))) {
                return false;
            }
        }
        return true;
    }


    class DSU{
        Map<String, String> parentMap;
        Map<String, Integer> rankMap;

        DSU(List<List<String>>  words){
            parentMap = new HashMap();
            rankMap = new HashMap();

            for(List<String> wordPair: words){
                parentMap.put(wordPair.get(0), wordPair.get(0));
                parentMap.put(wordPair.get(1), wordPair.get(1));
                rankMap.put(wordPair.get(0), 0);
                rankMap.put(wordPair.get(1), 0);
            }
        }   

        String find(String word) {
            if (parentMap.get(word).equals(word)) {
                return word;
            }
            parentMap.put(word, find(parentMap.get(word))); // Path compression
            return parentMap.get(word);
        }

        void union(String word1, String word2){
            String parentWord1 = parentMap.get(word1);
            String parentWord2 = parentMap.get(word2);

            if(!parentWord1.equals(parentWord2)){
                int rank1 = rankMap.get(parentWord1);
                int rank2 = rankMap.get(parentWord2);

                if(rank1 > rank2){
                    parentMap.put(parentWord2, parentWord1);
                }else if(rank2 > rank1){
                    parentMap.put(parentWord1, parentWord2);
                }else{
                    // same rank - parentWord2 became parent
                    parentMap.put(parentWord1, parentWord2);
                    rankMap.put(parentWord2, rankMap.getOrDefault(parentWord2, 0) + 1);
                }
            }
        }
    }
}
