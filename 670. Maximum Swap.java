class Solution {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        int n = numStr.length();
        int res = num;

        for(int i=0; i < n-1; i++){
            char c = numStr.charAt(i);
            // find maxDigit which is greater the itself to the right
            int pendingUpdateIdx = -1;
            char maxValue = c;
            int j = i+1;
            while(j < n){
                // for tests like: 1993 , we would O/p 9913 not 9193 
                if(numStr.charAt(j) > maxValue || (maxValue != c && numStr.charAt(j) == maxValue ) ){
                    pendingUpdateIdx = j;
                    maxValue = numStr.charAt(j);
                }
                j++;
            }

            if(pendingUpdateIdx == -1){
                // keep the loop running
                continue;
            }else{
                // swap the values and retunr
                // swap digits at i and pendingUpdateIdx
                return swap(numStr, i, pendingUpdateIdx);
            }
        }
        return res;
    }

    int swap(String numStr, int i, int pendingUpdateIdx){
        char[] numStrArray = numStr.toCharArray();
        char temp = numStrArray[i];
        numStrArray[i] = numStrArray[pendingUpdateIdx];
        numStrArray[pendingUpdateIdx] = temp;
        
        String resStr = new String(numStrArray);
        return Integer.parseInt(resStr);
    }
}
