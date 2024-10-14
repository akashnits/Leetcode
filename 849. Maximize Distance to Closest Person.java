class Solution {
    // Approach: 3 cases:
    // choose empty seat between two persons - if k is the number of empty seats, the k+1/2 is the ans

    // choose empty seat at the start (leading zeros count)
    // choose empty seat at the end (trailing zeros count)
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDistance = 0;
        
        // Handle leading zeros
        int i = 0;
        while (i < n && seats[i] == 0) {
            i++;
        }
        maxDistance = i;
        
        // Handle trailing zeros
        int j = n - 1;
        while (j >= 0 && seats[j] == 0) {
            j--;
        }
        maxDistance = Math.max(maxDistance, n - 1 - j);
        
        // Handle middle zeros - keep track of consecutive zeros (empty seats)
        int k =0;
        for(;i <= j; i++){
            if(seats[i] == 0){
                k++;
            }else{
                maxDistance = Math.max(maxDistance, (k+1)/2);
                k = 0;
            }
        }
        
        return maxDistance;
    }
}
