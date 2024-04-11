class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack();

        // keep track of open brackets
        int open =0;

        for(char c: s.toCharArray()){
            if(c == '('){
                // put it on the stack and increase count
                stack.push(c);
                open++;
            }else if ( c == ')'){
                // check if we have an open bracket to match, else ignore
                if(open > 0){
                    stack.push(c);
                    open--;
                }
            }else{
                stack.push(c);
            }
        }

        // check if all open brackets are closed i.e. open == 0
        // if not don't add them to result

        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()){
            char popped = stack.pop();

            // check if this is open bracket and open > 0
            if(popped == '(' && open > 0){
                // don't add this in result as it doesn't  have matching close
                open--;
            }else{
                res.insert(0, popped);
            }
        }
        return res.toString();
    }
}
