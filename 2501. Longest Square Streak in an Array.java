class Solution {
    public int longestSquareStreak(int[] nums) {
        // sort the array
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = -1;

        Set<Integer> seen = new HashSet();
        // loop over all values in nums
        for(int i=0 ; i < n; i++){
            // before finding a sequence for a num, make sure it doesn't exist in the seen set
            int num = nums[i];
            if(seen.contains(num)){
                continue;
            }
            // for each value in num, find the sequence len
            int newSeqLen = findSequence(nums, i, seen);
            // keep track of max size of sequence
            maxLen = Math.max(maxLen, newSeqLen);
        }
        return maxLen == 1 ? -1: maxLen;
    }


    // finding the sequence start at num
    // square the number and binray search , return index
    // repeat this process until binasr searh retuen -1 index

    int findSequence(int[] nums, int startIdx, Set<Integer> seen){
        int startVal = nums[startIdx];
        seen.add(startVal);
        int endIdx = nums.length -1;
        
        int square = startVal * startVal;
        int len = 1;
        while(square <= nums[endIdx]){
            // continue to binary search
            int idx = binarySearch(nums, startIdx+1, endIdx, square);

            if(idx == -1){
                // couldn't find, break
                break;
            }else{
                // add to sequence
                startVal = nums[idx];
                seen.add(startVal);
                square = startVal * startVal;
                len++;
            }
        }
        return len;
    }


    int binarySearch(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                // right
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}
