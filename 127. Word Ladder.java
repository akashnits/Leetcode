class Solution {
    // find the shortest path length ( could be more than one )
    // Time complexity: bdf travering each edge in O(average len of word *  V^2)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // task 1: build the graph of words which difer by 1 letter - rather do it on the go
        // task 2: run bfs and find length of shortest path

        int n = wordList.size() + 1; // number of graph nodes
        wordList.add(beginWord);

        Set<String> visitedSet = new HashSet();
        Set<String> wordSet = new HashSet<>(wordList);

        // task 2
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        visitedSet.add(beginWord);

        int level = 1; // start at level 1
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String polled = queue.poll();
                if (polled.equals(endWord))
                    return level;

                for (String neighbor : findNeighborsAtOneEditDist(polled, wordSet)) {
                    // offer to queue and mark visited
                    if (visitedSet.contains(neighbor))
                        continue;
                    queue.offer(neighbor);
                    visitedSet.add(neighbor);
                }
            }
            level++; // increase level for next iteration
        }

        return 0;
    }

    // we gegenrate sequence and put it in set for comparion e.g.
    // hit -> hat, hbt .... hzt
    // hit -> ait, bit... zit
    List<String> findNeighborsAtOneEditDist(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];

            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original)
                    continue;

                arr[i] = c;
                String next = new String(arr);

                if (wordSet.contains(next))
                    res.add(next);
            }

            arr[i] = original;
        }

        return res;
    }

}
