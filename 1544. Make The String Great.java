class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();

        for(Character c: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{
                // check if the previous char is same 
                Character prev = stack.peek();
                if(Math.abs(c- prev) == 32){
                    // pop it
                    stack.pop();
                }else{
                    // push the char
                    stack.push(c);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            char popped = stack.pop();
            res.append(popped);
        }
        return res.reverse().toString();
    }
}
