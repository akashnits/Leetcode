class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int i=0, j = s.length()-1;

        int count1 = 0, count2 =0;
        while( i < j ){
            if(vowels.contains(s.charAt(i++) + "")){
                count1++;
            }
            if(vowels.contains(s.charAt(j--) + "")){
                count2++;
            }
        }
        return count1 == count2;
    }
}
