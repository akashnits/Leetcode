class Solution {
    public int minChanges(String s) {
        // partition in chunks of size 2 and compare the values
        int n = s.length();
        int min = 0;

        int idx = 0;
        while(idx+1 < n){
            char c1 = s.charAt(idx);
            char c2= s.charAt(idx+1);
            if(c1 != c2){
                min++;
            } 
            idx += 2;
        }
        return min;
    }
}
