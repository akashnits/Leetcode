class Solution {
    public String makeFancyString(String s) {
        // keep track of consecutive
        int conscCount = 1;
        StringBuilder res = new StringBuilder();
        int size = 1;
        res.append(s.charAt(0));

        for(int i=1; i < s.length(); i++){
            char currChar = s.charAt(i);
            char prevChar = res.charAt(size -1);

            if(currChar == prevChar){
                // increase conscCount
                if(++conscCount <= 2){
                    res.append(currChar);
                    size++;
                }
            }else{
                // include this
                res.append(currChar);
                size++;
                // reset consc count
                conscCount = 1;
                prevChar = currChar;
            }
        }

        return res.toString();
    }
}
