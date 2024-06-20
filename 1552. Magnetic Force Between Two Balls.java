class Solution {
    public int maxDistance(int[] position, int m) {
        // force range from 1 .. max force
        int start  = 1;
        int n = position.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int p: position){
            min = Math.min(min, p);
            max = Math.max(max, p);
        }

        int end = max - min; // max force 
        int res = -1;

        Arrays.sort(position);
        while(start <= end){
            int minForce = start + (end - start)/2;
            if(isPlacementPossible(position, m, n, minForce)){
                res = minForce;
                // find greater, so go right
                start = minForce+1;
            }else{
                end = minForce-1;
            }
        }
        return res;
    }

    boolean isPlacementPossible(int[] position, int m, int n, int minForce) {
        // Place m balls at least minForce distance apart
        int count = 1;
        int prevPosition = position[0];

        for (int i = 1; i < n; i++) {
            if (position[i] - prevPosition >= minForce) {
                count++;
                prevPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
