class Solution {
    // Approach: maintain two stacks
    // 1st for keeping track of open brackets (indices)
    // 2nd for keeping track of asterisk (indices)
    public boolean checkValidString(String s) {
        Stack<Integer> openBracketsSt = new Stack();
        Stack<Integer> asteriskSt = new Stack();

        // loop over given string
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                // push index to stack
                openBracketsSt.push(i);
            }else if(c == ')'){
                // pop from openBracketsSt if not empty
                if(!openBracketsSt.isEmpty()){
                    openBracketsSt.pop(); // open matched with closed
                }else if(!asteriskSt.isEmpty()){ 
                    asteriskSt.pop(); // closed matched with asterisk
                }else{
                    // both empty, can't be matched -> return false
                    return false;
                }
            }else {
                // encountered *
                asteriskSt.push(i);
            }
        }

        // check if we have any open brackets left
        if(openBracketsSt.isEmpty()){
            return true;
        }else{
            // try matching them with asterisk 
            if(asteriskSt.isEmpty()){
                return false;
            }else{
                // loop over open brackets array and compare indices of both
                while(!openBracketsSt.isEmpty()){
                    if(asteriskSt.isEmpty() || openBracketsSt.peek() > asteriskSt.peek()){
                        return false; // can't match
                    }else{
                        openBracketsSt.pop();
                        asteriskSt.pop(); // match it
                    }
                }
            }
        }    
        return openBracketsSt.isEmpty();
    }
}
