class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        /// make begin word part of word dict
        wordSet.add(beginWord);

        // build graph for words which are one distance away
        Map<String, List<String>> graph = buildGraph(wordSet);

        //build a parent map so we can use it for path construction later
        // bfs ensure shortest path
        Map<String, List<String>> parentMap =
                bfsBuildParentMap(graph, beginWord, endWord);

        List<List<String>> result = new ArrayList<>();
        if (!parentMap.containsKey(endWord)) return result;

        LinkedList<String> path = new LinkedList<>();
        path.add(endWord);

        dfsBuildPaths(endWord, beginWord, parentMap, path, result);

        return result;
    }


    private Map<String, List<String>> buildGraph(Set<String> wordSet) {

        List<String> words = new ArrayList<>(wordSet);
        int n = words.size();

        Map<String, List<String>> graph = new HashMap<>();
        for (String w : words) graph.put(w, new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (oneEditDist(words.get(i), words.get(j))) {
                    graph.get(words.get(i)).add(words.get(j));
                    graph.get(words.get(j)).add(words.get(i));
                }
            }
        }

        return graph;
    }


    private Map<String, List<String>> bfsBuildParentMap(
            Map<String, List<String>> graph, // child -> list(parent)
            String beginWord,
            String endWord) {

        Map<String, List<String>> parentMap = new HashMap<>();

        Set<String> globalVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        globalVisited.add(beginWord);

        boolean foundEnd = false;

        while (!queue.isEmpty() && !foundEnd) {

            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                for (String neigh : graph.get(word)) {

                    if (!globalVisited.contains(neigh)) {

                        parentMap.computeIfAbsent(neigh, k -> new ArrayList<>());
                        parentMap.get(neigh).add(word);

                        if (!levelVisited.contains(neigh)) {
                            queue.add(neigh);
                            levelVisited.add(neigh);
                        }

                        if (neigh.equals(endWord)) foundEnd = true;
                    }
                }
            }

            globalVisited.addAll(levelVisited);
        }

        return parentMap;
    }


    private void dfsBuildPaths(
            String curr,
            String beginWord,
            Map<String, List<String>> parentMap,
            LinkedList<String> path,
            List<List<String>> result) {

        // base condition
        if (curr.equals(beginWord)) {
            List<String> valid = new ArrayList<>(path);
            Collections.reverse(valid);
            result.add(valid);
            return;
        }

        if (!parentMap.containsKey(curr)) return;

        for (String parent : parentMap.get(curr)) {
            path.addLast(parent);
            dfsBuildPaths(parent, beginWord, parentMap, path, result);
            path.removeLast();
        }
    }


    private boolean oneEditDist(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}
