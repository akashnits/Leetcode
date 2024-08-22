class Solution {
    public int findComplement(int num) {
        // represent in binary
        StringBuilder sb = new StringBuilder();

        int res = 0;
        int idx = 0;
        while(num > 0){
            int remainder = num % 2;
            num = num/2;
            int bit = remainder == 0 ? 1: 0; // flip the bit here
            res = res + (bit << idx);
            idx++;
        }

        return res;
    }
}
