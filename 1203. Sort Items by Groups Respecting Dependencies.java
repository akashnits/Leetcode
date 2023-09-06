class Solution {

    //Approach: use Topological sort
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        int V = n;
        List<List<Integer>> adjList = new ArrayList();
        for(int v=0; v < V; v++){
            adjList.add(new ArrayList<Integer>());
        }
        // construct a DAG
        for(int i=0; i < beforeItems.size(); i++){
            List<Integer> dependencyList= beforeItems.get(i);

            for(int dependency: dependencyList){
                // put i in DAG
                adjList.get(dependency).add(i);
            }
        }

        // toposort the items based on dependency
        List<Integer> sortedItemList = toposort(adjList, V);
        if(sortedItemList.size() != n) return new int[0];   

        // toposort the group based
        int groupId = m;
        for(int g=0; g < n; g++){
            if(group[g] == -1) {
                group[g] = groupId++;
            }
        }

        // create a DAG based on group
        List<List<Integer>> groupList = new ArrayList();
        for(int v=0; v < groupId; v++){
            groupList.add(new ArrayList<Integer>());
        }

        // loop over all the items
        for(int i=0; i< n; i++){
            // check before items
            int itemGroup = group[i];
            if(beforeItems.get(i).isEmpty()) continue; // no need to add an edge

            for(int beforeItem: beforeItems.get(i)){
                // figure out the group of item
                int beforeItemGroup = group[beforeItem];
                if(itemGroup == beforeItemGroup) continue; // they are in the same group

                // if different group, add an edge from beforeItemGroup to itemGroup
                groupList.get(beforeItemGroup).add(itemGroup);
            }
        }

        List<Integer> sortedGroupList = toposort(groupList, groupId);
        if(sortedGroupList.size() != groupId) return new int[0];


        List<List<Integer>> res = new ArrayList();
        // create a list for all groups
        for(int g=0; g < groupId; g++){
            res.add(new ArrayList());
        }

        // loop over sorted items and add to respective groups
        for(int i=0; i < V; i++){
            int ele = sortedItemList.get(i);
            // add element to group
            res.get(group[ele]).add(ele);
        }

        int idx =0;
        int[] finalRes = new int[n];
        // loop over sorted group list
        for(int l: sortedGroupList){
            for(int item: res.get(l)){
                finalRes[idx++] = item;
            }
        }

        return finalRes;
    }



    List<Integer> toposort(List<List<Integer>> adjList, int V){
        List<Integer> itemList = new ArrayList();

        // create indegree array
        int[] indegree = new int[V];
        // loop over adjcaency list and calculate indegree of each node
        for(List<Integer> nodes: adjList){
            for(int node: nodes){
                indegree[node]++;
            }
        }

        Queue<Integer> q = new ArrayDeque();

        // find indegree having value 0
        for(int v=0; v < V; v++){
            if(indegree[v] == 0){
                q.offer(v);
            }
        }

        while(!q.isEmpty()){
            // poll and process
            Integer polled = q.poll();
            itemList.add(polled);

            // loop through it's neighbors
            for(Integer neighbor: adjList.get(polled)){
                if(--indegree[neighbor] == 0){
                    // add to queue
                    q.offer(neighbor);
                }
            }
        }
        return itemList;
    }
}
