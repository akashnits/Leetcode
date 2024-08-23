class Solution {
    public int minSteps(int n) {
        // start with one char 'A' on notepad
        // no char on clipboard
        if( n == 1){
            return 0;
        }
        // notepad should have n ( > 1) number of A's
        // at each step we can either copy or paste

        int[][] dp = new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return 1 + minOps(n, 1, 1, dp);
    }


    int minOps(int n, int notepadCharCount, int clipboardCharCount, int[][] dp){
        // base condition
        if(notepadCharCount == n){
            return 0;
        }

        if(dp[notepadCharCount][clipboardCharCount] != -1){
            return dp[notepadCharCount][clipboardCharCount];
        }

        // choices we have:
        int paste = n+1;
        int copy = n+1;
        // we can always paste if after pasting notepadCharCount <= n
        if(notepadCharCount + clipboardCharCount <= n){
            // paste 
            paste = 1 + minOps(n, notepadCharCount+clipboardCharCount, clipboardCharCount, dp);
        }

        // we can't copy if same length or after copying we can't paste it
        if( notepadCharCount != clipboardCharCount && (2 * notepadCharCount <= n)){
            copy = 1 + minOps(n, notepadCharCount, notepadCharCount, dp);
        }

        return dp[notepadCharCount][clipboardCharCount] = Math.min(copy, paste);
    }
}
