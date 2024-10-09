class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                open++;
            }else{
                // we have ) here, check if we can balance it ?
                if(open > 0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        return open+close;
    }
}
