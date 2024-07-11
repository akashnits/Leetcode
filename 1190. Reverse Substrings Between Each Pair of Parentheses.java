class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack();
        LinkedList<Character> queue = new LinkedList();

        for(char c: s.toCharArray()){
            if(c != ')'){
                // push this char on stack
                stack.push(c);
            }else{
                // we have a closing bracket
                // pop from stack we find opening bracket
                // add to queue

                while(stack.peek() != '('){
                    char popped = stack.pop(); // this is a char, add to queue
                    queue.offer(popped);
                }
                // we have a opening bracket here, pop it
                stack.pop();

                // loop over queue and add back to stack
                while(!queue.isEmpty()){
                    stack.push(queue.poll()); // now the order is reversed and () is processed
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop() + "");
        }
        return sb.toString();
    }
}
