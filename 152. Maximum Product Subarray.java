class Solution {
    public int maxProduct(int[] nums) {
        int maxP=nums[0];  //Stores the maximum product soo far
        int minP=nums[0];  //Stores the minimum product soo far basically the -ve product
		int ans=nums[0];   //Stores the answer to be returned
        
		for(int i=1;i<nums.length;i++){
            int first=nums[i];         //First Possibility
            int second=maxP*nums[i];   //Second Possibility
            int third=minP*nums[i];    //Third Possibility
            minP=Math.min( Math.min(first,second) ,third);
            maxP=Math.max( Math.max(first,second) ,third);
            ans=Math.max(ans,maxP);
            
        }
        return ans;
    }
}
