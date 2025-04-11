class Solution {
    // Approach: Since we have three pointers, can we fix two pointers and iterate over 3rd ? 
    // we need two maximum - one to calculate diff ( a - b) and second to multiply the diff with
    // i and k -> are indices corresponding to these maximums while j is floating 

    // array to left of j -> first half i.e. 0...j-1
    // array to right of j  -> second half i.e. j+1..n-1


    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] firstHalfMax = new int[n];
        int[] secondHalfMax = new int[n];

        int maxFromStart = 0;
        for(int i=0; i < n; i++){
            maxFromStart = Math.max(maxFromStart, nums[i]);
            firstHalfMax[i] = maxFromStart;
        }

        int maxFromEnd = 0;
        for(int i=n-1; i >= 0; i--){
            maxFromEnd = Math.max(maxFromEnd, nums[i]);
            secondHalfMax[i] = maxFromEnd;
        }

        long tripletMax = 0;
        // j moves from 1 to n-2
        for(int j=1; j < n-1; j++){
            long tripletVal = (firstHalfMax[j-1] - nums[j]) * (long) secondHalfMax[j+1];
            tripletMax = Math.max(tripletMax, tripletVal);
        }
        return tripletMax;
    }
}


