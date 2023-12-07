class Solution {
    // Approach: Visialize matrix as tree and do bfs as diagonals
    // are nothing but levels
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> res= new ArrayList();
        int n = nums.size();
        Queue<Pair<Integer, Integer>> q = new LinkedList();

        // add the source
        q.offer(new Pair(0, 0));

        while(!q.isEmpty()){
            Pair<Integer, Integer> pair= q.poll();
            int row = pair.getKey();
            int col = pair.getValue();

            res.add(nums.get(row).get(col));

            // we need to move in two directions:
            // (row+1, col) and (row, col+1)

            if(col == 0 && row < n-1){
                // add to queue
                q.offer(new Pair(row+1, col));
            }

            if(col < nums.get(row).size()-1){
                q.offer(new Pair(row, col+1));
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
