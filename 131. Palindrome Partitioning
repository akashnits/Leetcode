class Solution {
    // Backtracking algorithm to solve
    
    // we want to partition string into palindromic substrings
    
    // we partition (make a choice) and make input smaller  until input string length is 0
    
    // we check to see if substring is palindrome, if yes then proceed to explore
    // to find other palindromic substring (i.e. recurse on our decision)
    
    //we undo partitioning and continue
    
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList();
        solve(s, new ArrayList(), result);
        return result;
    }
    
    
    void solve(String s,  List<String> op, List<List<String>> result){
        
        //base condition
        if(s == null || s.length() == 0){
            result.add(new ArrayList(op));
            return;
        }
        
        //iterate over choices
        for(int i=1; i<= s.length(); i++){
            
            String firstPart= s.substring(0, i);
            
            //make a decision (partition and check if palindrome)
            if(!isPalindrome(firstPart)) continue;
            
            //add to output
            op.add(firstPart);
            //explore
            solve(s.substring(i), op, result);
            //undo
            op.remove(op.size()-1);
        }
        
    }
    
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
