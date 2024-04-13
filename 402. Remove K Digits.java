class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        StringBuilder res = new StringBuilder();

        Stack<Integer> minStack = new Stack();

        // maintain monotonic stack with increasing value
        // we remove peaks until k == 0

        for(int i = 0; i < n ; i++){
            // check if incoming is smaller than stack top
            int incoming = num.charAt(i) - '0';

            while(!minStack.isEmpty() && k > 0 && incoming < minStack.peek()){
                minStack.pop();
                k--;
            }
            minStack.push(incoming);
        }

        while(k > 0 && !minStack.isEmpty()){
            minStack.pop();
            k--;
        }

        while(!minStack.isEmpty()){
            res.insert(0, minStack.pop());
        }
        

        // remove leading zeros
        // count number of leading zeros
        int idx =0;
        while(idx < res.length() && res.charAt(idx) == '0'){
            idx++;
        }

        String ans  = res.substring(idx, res.length());
        return  ans.length() == 0 ? "0": ans ;
    }
}
