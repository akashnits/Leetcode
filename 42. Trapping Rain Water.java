class Solution {
    public int trap(int[] height) {
        // create two arrays 
        // 1. max height to the left 
        // 2. max height to the right
        int n = height.length;

        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];

        // populating left max height array
        int leftMax = -1;
        leftMaxHeight[0] = leftMax;
        for(int l =1; l < n; l++){
            if(height[l-1] >= leftMax){
                leftMax = height[l-1];
            }
            leftMaxHeight[l] = leftMax;
        }

        // populating right max height array
        int rightMax = -1;
        rightMaxHeight[n-1] = rightMax;
        for(int r = n-2; r >=0; r--){
            if(height[r+1] >= rightMax){
                rightMax = height[r+1];
            }
            rightMaxHeight[r] = rightMax;
        }

        // calculate water trapped

        int ans = 0;

        for(int i = 1; i < n-1; i++){
            // first and last can never trap water
            // bounded by min
            int minHeight = Math.min(leftMaxHeight[i], rightMaxHeight[i]); 
            if(minHeight > height[i]){
                ans += minHeight - height[i];
            }
        }
        return ans;
    }
}
