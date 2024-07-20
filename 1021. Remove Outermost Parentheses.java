class Solution {
    public String removeOuterParentheses(String s) {
        List<String> primitiveList = new ArrayList();
        
        Stack<Character> stack = new Stack();
        int prev = 0;
        
        for(int idx=0; idx < s.length(); idx++){
            // check the incoming char
            char c = s.charAt(idx);
            if(c == '('){
                // push
                stack.push('(');
            }else{
                // we have a closing bracket, pop from stack (stack wouldn't be empty for sure as given)
                stack.pop();
            }
            
            // check if stack is empty ?
            if(stack.isEmpty()){
                // we have found a primitive valid parentheses
                primitiveList.add(s.substring(prev, idx+1));
                // update prev
                prev = idx+1;
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        for(String primitive: primitiveList){
            res.append(primitive.substring(1, primitive.length()-1));
        }
        return res.toString();
    }
}
