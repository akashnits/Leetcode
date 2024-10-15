class Solution {
    // keep track of black balls encountered to the left
    // number of swaps would be count of black balls for white white ball to be pushed
    // to left of all black balls
    public long minimumSteps(String s) {
        long res = 0;
        int blackBallsToLeft = 0;

        for(char c: s.toCharArray()){
            if(c == '0'){
                // encountered white ball, number of swaps required == black ball count
                res += blackBallsToLeft;
            }else{
                // encountered black ball to the left
                blackBallsToLeft++;
            }
        }
        return res;
    }
}
