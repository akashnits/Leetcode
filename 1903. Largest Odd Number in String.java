class Solution {
    public String largestOddNumber(String num) {
       String res = "";
       int digit;
       int n = num.length();
       for(int i=0; i < n; i++){
           digit = Character.getNumericValue(num.charAt(n-1-i));
           if( digit%2 == 1 ){
               res = num.substring(0,  n-i);
               break;
           }
       } 
       return res;
    }
}
