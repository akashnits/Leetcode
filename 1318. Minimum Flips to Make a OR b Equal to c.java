class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            int mask = 1 << i;

            int aBit = a & mask;
            int bBit = b & mask;
            int cBit = c & mask;

            if(cBit == 0){
                // both bits must be zero
                if(aBit != 0){
                    res++;
                }
                if(bBit != 0){
                    res++;
                }
            }else{
                // at least one bit should be set
                if(aBit == 0 && bBit == 0){
                    res++;
                }
            }
        }

        return res;
    }
}
