class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack();
        int n = s.length();
        for(int i=0; i < n ; i++){
            char c = s.charAt(i);
            // if incoming is B and stack top is A
            // or incoming in D and stack top is C
            if(!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || ( c == 'D' && stack.peek() == 'C')) ){
                // pop from stack
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        // count characteres on stack
        int count =0;
        while(!stack.isEmpty()){
            stack.pop();
            count++;
        }
        return count;        
    }
}
