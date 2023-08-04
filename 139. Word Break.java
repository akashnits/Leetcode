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
    // Approach: partitioning problem: choices is to partition from len 1 to strLen-start
    // explore all possibilities and return if true as we want just one valid sequence 
    Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // initialize dict
        dict = new HashSet();
        for(String str: wordDict){
            dict.add(str);
        }

        return partition(s, 0, new Boolean[n]); 
    }


    boolean partition(String s, int start, Boolean[] dp){
        // base condition
        if(start == s.length()){
            //we have reached the end, return true
            return true;
        }

        if(dp[start] != null){
            return dp[start];
        }

        // choices we have, we want to partition from length 1 to strLen-start

        for(int i=1; i <= s.length()- start; i++){
            String word = s.substring(start, start + i);
            if(!canPick(word)) continue;

            // we can pick this, explore and partition futher 
            dp[start] = partition(s, start + word.length(), dp);
            if(dp[start]){
                return true; // we can return true if any exploration lead to a valid sequence 
            }
        }

        dp[start] = false;
        return dp[start];
    }



    boolean canPick(String word){
        return dict.contains(word);
    }
}
