class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        return solve(arr, start, visited);
    }

    boolean solve(int[] arr, int currIdx, boolean[] visited){
        // check taget met
        if(arr[currIdx] == 0){
            return true;
        }


        int[] dist = {arr[currIdx], -arr[currIdx]};

        for(int d: dist){
            int newIdx = d + currIdx;

            // if newIdx isn't valid
            if(newIdx < 0 || newIdx > arr.length-1 || visited[newIdx]){
                continue;
            }
            visited[newIdx] = true;
            if(solve(arr, newIdx, visited)){
                return true;
            }
        }
        
        return false;
    }
}
