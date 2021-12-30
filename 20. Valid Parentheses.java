class Solution {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack();
        
        for(char c: charArray){
            switch(c){
                case '(' : 
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default : if(stack.isEmpty() || stack.pop() != c) return false;       
            }
        }
        return stack.isEmpty();
    }
}
