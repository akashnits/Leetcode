class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] setBitArr = new int[n];
        for(int i=0; i < n; i++){
            setBitArr[i] = countSetBits(nums[i]);
        }

        // group and sort
        int start = 0;
        int end = 0;

        int windowSetBit = setBitArr[0];

        List<int[]> minMaxSegments = new ArrayList();
        while(start < n){
            // find the max and min value for each segment
            int max = nums[start];
            int min = nums[start];
            while(end < n -1 && setBitArr[end] == setBitArr[end+1]){
                // we can expand here
                end++;
                max = Math.max(max, nums[end]);
                min = Math.min(min, nums[end]);
            }

            // store the min-max for this segment
            minMaxSegments.add(new int[]{min, max});

            // once sorted, reset start and end
            start = end+1;
            end = start;
        }

        // check if array is sorted by comparing min -max for each segment
        for(int i=1; i < minMaxSegments.size(); i++){
            int[] lastSeg = minMaxSegments.get(i-1);
            int[] currSeg = minMaxSegments.get(i);

            if(currSeg[0] < lastSeg[1]){
                return false;
            }
        }
        return true;
    }

    int countSetBits(int n){
        int count = 0;
        while(n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
