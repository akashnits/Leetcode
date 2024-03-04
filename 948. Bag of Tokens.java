class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // try to play face up to boost score as much as possible ( use lower value tokens )
        // if we can't play face up, we have to play face down ( use highest value token to get maximum boost)

        // repeat the process

        // use two pointers after sorting
        Arrays.sort(tokens);
        int low =0, high = tokens.length-1;

        int score = 0;

        while(low <= high){ // play until we exhaust all tokens
            // we try playing face up
            if(power >= tokens[low]){
                score += 1;
                power -= tokens[low++];
            }else if(score >= 1 && low <= high-1 ){ // we don't want a boost which we can't utilize
                // try playing face down 
                score -= 1;
                power += tokens[high--];
            }else{
                // we couldn't do anything, so quit
                break;
            }
        }
        return score;
    }
}
