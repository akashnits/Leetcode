class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
     // create a map of colors to their positions
        int n = colors.length;
        
        Map<Integer, List<Integer>> map = new HashMap();
        
        for(int i=0; i < n; i++){
            map.putIfAbsent(colors[i], new ArrayList());
            // list is in sorted order
            map.get(colors[i]).add(i);
        }
        
        List<Integer> res = new ArrayList();
        
        // iterate through queries
        for(int[] query: queries){
            int index = query[0];
            int color = query[1];
            
            // check if this color exists
            if(map.containsKey(color)){
                // find the position at which this color exists
                List<Integer> positionsList = map.get(color);
                // sorted list , apply binary serach to find nearest values
                int[] neighbors = binarySearch(positionsList, index);
                // compare with both neighbors and find shortest distance
                int distanceFromNeighbor1 = Math.abs(neighbors[0] - index);
                int distanceFromNeighbor2 = Math.abs(neighbors[1] - index); 
                
                int minDistance = Math.min(distanceFromNeighbor1, distanceFromNeighbor2);
                res.add(minDistance);
            }else{
                // color doesn't exist
                res.add(-1);
            }
        }
        return res;
    }
    
    
    int[] binarySearch(List<Integer> positionsList, int target) {
        int start = 0;
        int end = positionsList.size() - 1;
    
        while (start <= end) {
            int mid = start + (end - start) / 2;
        
            if (positionsList.get(mid) == target) {
                return new int[] {positionsList.get(mid), positionsList.get(mid)};
            } else if (positionsList.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    
        // At the end of the loop, start is the first position greater than target,
        // and end is the last position less than target.
        int leftNeighbor = (end >= 0) ? positionsList.get(end) : Integer.MAX_VALUE;
        int rightNeighbor = (start < positionsList.size()) ? positionsList.get(start) : Integer.MAX_VALUE;
    
            return new int[] {leftNeighbor, rightNeighbor};
        }

}
