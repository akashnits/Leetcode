class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        String newStr = s;
        int i =0;
        
        while( i++ < s.length()){
            String fpart = newStr.substring(0, 1);
            String rpart = newStr.substring(1);
            
            newStr = rpart + fpart;
            if(newStr.equals(goal)){
                return true;
            }
        }
        return false;
    }
}
