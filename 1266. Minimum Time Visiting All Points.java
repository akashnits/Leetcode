class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] initialPoint;
        int[] nextPoint;

        int n = points.length;
        int sum =0;

        for(int i=1; i < n; i++){
            initialPoint = points[i-1];
            nextPoint = points[i];

            // calculate time taken to reach 
            // move diagonally until we reach any of the points
            int dx = nextPoint[1]- initialPoint[1];
            int dy = nextPoint[0] - initialPoint[0];
            int diagonalUnits = Math.min(Math.abs(dx), Math.abs(dy));
            sum = sum + diagonalUnits;

            // if diagonalUnits == dx, travel dy-diagonalUnits
            if(diagonalUnits == Math.abs(dx)){
                sum = sum + (Math.abs(dy) - diagonalUnits);
            }else if(diagonalUnits == Math.abs(dy)){
                sum = sum + (Math.abs(dx) - diagonalUnits);
            }
        }

        return sum;
    }
}
