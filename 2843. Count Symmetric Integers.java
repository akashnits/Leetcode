class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for(int num=low; num <= high; num++){
            String numStr= String.valueOf(num);
            int len = numStr.length();

            if(len % 2 == 1){
                continue;
            }

            int midIdx = len /2;

            // partition 1: 0.. midIdx-1
            // partition 2: midIdx.. len-1

            int sum1 = 0;
            int sum2 = 0;

            for(int i=0; i< midIdx; i++){
                sum1 += (int) (numStr.charAt(i) - '0');
            }

            for(int j=midIdx; j < len; j++){
                sum2 += (int) (numStr.charAt(j) - '0');
            }

            if(sum1 == sum2){
                count++;
            }
        }
        return count;
    }
}
