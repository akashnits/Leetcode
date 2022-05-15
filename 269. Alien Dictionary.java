class Solution {
    public String alienOrder(String[] words) {
        // construct adajacency map
        Map<Character, Set<Character>> graph = new HashMap();
        
        // loop over words array
        for(String word: words){
            
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                // Check that word2 is not a prefix of word1.
                if (word1.length() > word2.length() && word1.startsWith(word2)) {
                    return "";
                }
                // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if(graph.get(word1.charAt(j)) == null){
                        graph.put(word1.charAt(j), new HashSet());
                }
                if(graph.get(word2.charAt(j)) == null){
                        graph.put(word2.charAt(j), new HashSet());
                }
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        }
            
            // create indegree array
            int[] indegree = new int[26];
            for(Map.Entry<Character, Set<Character>> entry : graph.entrySet()){
                for(char c: entry.getValue()){
                    if(graph.containsKey(c)){
                        indegree[c-'a']++;
                    }
                }
            }
            
            Queue<Character> q= new LinkedList();
            
            // loop over indegree array and find indegree[j] == 0
            for(int j=0; j < 26; j++){
                char c= (char) ('a'+ j);
                if(graph.containsKey(c) && indegree[j] == 0){
                    q.offer(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!q.isEmpty()){
                
                Character c= q.poll(); 
                sb.append(c);
                
                for(char neighbor: graph.get(c)){
                    indegree[neighbor-'a']--;
                    if(indegree[neighbor-'a'] == 0){
                        q.offer(neighbor);
                    }
                }
            } 
            
            if(sb.length() != graph.size()){
                return "";
            }
            return sb.toString();
        }
    }
