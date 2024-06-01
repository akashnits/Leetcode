class Solution {
    public int[] singleNumber(int[] nums) {
        // Approach 1: Using a set
        // Set<Integer> set = new HashSet();
        // for(int num: nums){
        //     if(set.contains(num)){
        //         set.remove(num);
        //     }else{
        //         set.add(num);
        //     }
        // }
        // int n = set.size();
        // int[] res = new int[n];

        // int i=0;
        // for(int ele: set){
        //     res[i++] = ele;
        // }
        // return res;

        // using bit manipulation

        // step 1: XOR all numbers
        int xorResult = 0;

        for(int num: nums){
            xorResult ^= num;
        }

        // step 2:
        // we have XOR of output, which are 2 numbers
        // we try partitioning every number in two partition based on some logic
        // such that these 2 number fall in different partitions
        // same numbers fall in same partition


        // observing xorResult, if a bit is set in result, it means the bits on which XOR operated
        // were different

        // we can partition the numbers into two groups based on this bit

        // find the set bit in xorResult
        int setBitPos = 0;
        int mask = 1;
        while(setBitPos < 32){
            mask = (1 << setBitPos);
            if((mask & xorResult) != 0){
                break;
            }
            setBitPos++;
        }
        
        int xorGroup1 = 0;
        int xorGroup2 = 0;
        // we have a valid mask now, group numbers based on this mask
        for(int num: nums){
            if((num & mask) == 0){
                xorGroup1 ^= num;
            }else{
                xorGroup2 ^= num;
            }
        }

        return new int[]{xorGroup1, xorGroup2};
    }
}
