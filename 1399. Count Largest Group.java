class Solution {
    public int countLargestGroup(int n) {
        // groupSize -> count
        Map<Integer, Integer> map = new HashMap();
        // maxGroupSize
        int maxGroupSize = 0;

        for(int i=1; i <=n; i++){
            // calculate sum of it's digits
            int groupSize = sumDigits(i);
            map.put(groupSize, map.getOrDefault(groupSize, 0) + 1);
            maxGroupSize = Math.max(maxGroupSize, map.get(groupSize));
        }
        
        int res = 0;
        // count number of keys which have value == maxGroupSize
        for(int val: map.values()){
            if(val == maxGroupSize){
                res++;
            }
        }
        return res;
    }

    int sumDigits(int num){
        int sum = 0;
        while(num > 0 ){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
