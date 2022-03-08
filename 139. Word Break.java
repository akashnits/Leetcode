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
