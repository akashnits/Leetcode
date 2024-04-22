class Solution {
    // approach: build the graph - edges with 1 digit apart and not a deadend
    // find shortest path src to destination
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet();
        for(String deadend: deadends){
            set.add(deadend);
        }
        return bfs(set, target, new HashSet());
    }


    int bfs(Set<String> deadendSet, String target, Set<String> visited){
        Queue<Node> queue = new LinkedList();
        if(!deadendSet.contains("0000")){
            queue.add(new Node("0000"));
        }
        int level =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                // process all nodes at this level
                Node polled = queue.poll();
                // check if polled node is the ans
                if(polled.val.equals(target)){
                    return level;
                }
                // loop over all its children and add to queue if not deadend
                for(String children: getChildren(polled)){
                    // add to queue if not deadend
                    if(!deadendSet.contains(children) && !visited.contains(children)){
                        visited.add(children);
                        queue.add(new Node(children));
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public List<String> getChildren(Node node){
        List<String> res = new ArrayList();
        String parent = node.val;
        // loop over each char and add +1, -1
        for(int i=0; i < 4; i++){
            char c = parent.charAt(i);
            char nextChar = (c == '9'? '0' : (char)(c + 1));
            char prevChar = (c == '0'? '9' : (char)(c -1));

            StringBuilder nextSb = new StringBuilder(parent);
            nextSb.setCharAt(i, nextChar);
            res.add(nextSb.toString());

            StringBuilder prevSb = new StringBuilder(parent);
            prevSb.setCharAt(i, prevChar);
            res.add(prevSb.toString());
        }
        return res;
    }

    class Node{
        String val;
        Node next;

        Node(String val){
            this.val= val;
        }
    }
}
