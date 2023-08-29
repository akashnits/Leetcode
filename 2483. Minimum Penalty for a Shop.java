class Solution {
    public int bestClosingTime(String customers) {
        // create arrays keeping count of Y and N
        int n = customers.length();

        // count Y from right, 0 at last position
        int[] arrY = new int[n+1];
        arrY[n] = 0;

        int countY=0;
        for(int j=n-1; j >=0; j--){
            if(customers.charAt(j) == 'Y') {
                countY++;
            }
            arrY[j] = countY;
        }

        // count N from left, 0 at first position
        int[] arrN= new int[n+1];
        arrN[0] = 0;

        int countN = 0;
        for(int i=1; i <=n; i++){
            if(customers.charAt(i-1) == 'N'){
                countN++;
            }
            arrN[i] = countN;
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        // loop over both arrays, sum and calculate min
        for(int k=0; k <=n ; k++){
            int sum = arrY[k] + arrN[k];
            if(sum < min){
                min = sum;
                minIndex = k;
            }
        }
        return minIndex;
    }
}
