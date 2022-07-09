class Solution {
    // unbounded knapsack problem
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict, s.length());
    }
    
    
    private boolean solve(String s, List<String> wordDict, int n){
        // base condition
        if( n == 0){
            return true;
        }
        
        //choice diagram
        
        // iterate over wordDict
        for(String word : wordDict){
            
            int len = word.length();
            // check boundary
            if(n >= len){
                // compare substring ending at index n-1 with word
                if(word.equals(s.substring(n-len, n))){
                    // we may include this or ignore
                    boolean resultInclude=  solve(s, wordDict, n-len); 
                    wordDict.remove(word);
                    boolean resultExclude=  solve(s, wordDict, n);
                    return resultInclude || resultExclude;
                }
            }
        }
        return false;
    }
}


class Solution {
    // state variable -> start varies from 0 to n
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n];
        return solve(s, wordDict, 0, dp);
    }
    
    boolean solve(String s, List<String> wordDict, int start, Boolean[] dp){
        
        // base condition
        if(start == s.length()){
            return true;
        }
        
        if(dp[start] != null){
            return dp[start];
        }
        
        // choice diagram
        for(String word: wordDict){
            if(canPick(word, s, start)){
                if(solve(s, wordDict, start+ word.length(), dp)){
                    dp[start] = true;
                    return true;
                }
            }
        }
        dp[start] = false;
        return dp[start];
    }
    
    
    boolean canPick(String word, String s, int start){
        
        int end = start + word.length();
        if(end > s.length()){
            return false;
        }
        String toCompare= s.substring(start, end);
        return toCompare.equals(word);
    }
}
