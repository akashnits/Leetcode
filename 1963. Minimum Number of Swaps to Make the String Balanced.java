class Solution {
    // ]]][[[ 
    // each swap could balance 2 pair of parenthesis at max
    // ][][][
    // [][][] - took 2 swaps to balance it
    // formulate it - (no of unbalanced open/closed brackets + 1) / 2
    // why +1 ? : a swap could balance 1 pair or 2 pairs
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && c == ']' && stack.peek() == '['){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        int noOpenBrackets = stack.size() / 2;
        return (noOpenBrackets + 1)/2;
    }
}
