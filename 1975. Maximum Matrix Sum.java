class Solution {
    // Think: we can convert all negative to pistives if negatives are even
    // if it's odd, there would always be one left
    // so, to maximize - we want the negative to be the smallest

    // Aprooach: sum all element and keep track of minAbsVal and negatives count
    // if negatives count is odd - substract twice the minAbsValue else totalSum is ans
    public long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        int minAbsVal = Integer.MAX_VALUE;

        long sum = 0;

        for(int r=0; r < matrix.length; r++){
            for(int c=0; c < matrix[0].length; c++){
                sum += Math.abs(matrix[r][c]);
                negativeCount += matrix[r][c] < 0 ? 1: 0;
                minAbsVal = Math.min(minAbsVal, Math.abs(matrix[r][c]));
            }
        }

        if(negativeCount % 2 == 1){
            // odd number of negative values, so decrement the min value - twice
            sum -= 2 * minAbsVal;
        }

        return sum;
    }
}
