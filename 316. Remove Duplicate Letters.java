class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();

        int[] lastIdxArray = new int[26];
        boolean[] taken = new boolean[26];
        Arrays.fill(lastIdxArray, -1);
        // record the last index of each char
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            lastIdxArray[c - 'a'] = i;
        }

        stack.push(s.charAt(0));
        taken[s.charAt(0) - 'a'] = true;

        // loop over string s
        for(int i=1; i< s.length(); i++){
            char c = s.charAt(i);
            if(taken[c- 'a']) continue;

            // while stack isn't empty and top > incoming element
            while(!stack.isEmpty() && stack.peek() > c){
                char stackTopChar = stack.peek();
                // check if stackTopChar comes afterwards
                if(lastIdxArray[stackTopChar - 'a'] > i){
                    // pop from stack top
                    taken[stackTopChar- 'a'] = false;
                    stack.pop();
                }else{
                    // don't pop from the stack
                    break;
                }
            }

            
            stack.push(c);
            taken[c-'a']= true;
            
        }

        // loop over stack and create a string
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
