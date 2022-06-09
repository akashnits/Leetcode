class Solution {
    // approach: use two pointers - start and end , we move the pointer 
    // in the direction where height is greater
    public int maxArea(int[] height) {
        int n = height.length;
        
        int start = 0;
        int end = n-1;
        
        int maxWaterContained =0;
        int minHeight =0;
        int width =0;
        
        while( start < end ){
            minHeight = Math.min(height[start], height[end]);
            width = end - start;
             
            maxWaterContained = Math.max(maxWaterContained, minHeight * width);
            
            if(height[start] < height[end]){
                // we move start pointer
                start++;
            }else{
                end--;
            }
        }
        
        return maxWaterContained;
    }
}
