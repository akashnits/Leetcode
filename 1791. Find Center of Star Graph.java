class Solution {
    public int findCenter(int[][] edges) {
        // //approach 1
        // int n = edges.length+1; // number of nodes is n, with edges n-1
        // int[] indegree = new int[n+1];

        // for(int[] edge: edges){
        //     int u = edge[0];
        //     int v = edge[1];

        //     // edge from  u ->v , v-> u
        //     indegree[v]++;
        //     indegree[u]++;

        //     if(indegree[u] == n-1){
        //         return u;
        //     }

        //     if(indegree[v] == n-1){
        //         return v;
        //     }
        // }
        // return -1;

        // approach 2
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
		    return edges[0][0];
	    } else {
		    return edges[0][1];
	    }
    }
}
