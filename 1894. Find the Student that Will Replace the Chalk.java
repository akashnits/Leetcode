class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // sum chalks count
        long chalkSum = 0;
        for(int ck: chalk){
            chalkSum += ck;
        }
        // mod k by chalkCount, so we iterate the array just once
        k %= chalkSum;

        if( k == 0){
            return 0; // chalk would be replace by first student
        }

        // loop though the chalk array and find if there's enough chalk to ans
        int n = chalk.length;
        for(int i=0; i < n; i++){
            int chalkReq = chalk[i];
            // we have k chalk, see if it's enough
            if(k >= chalkReq){
                k -= chalkReq; // use the chalk to ans
            }else{
                return i;
            }
        }

        return -1; // this would never happen as 0 <= k < chalkSum
    }
}
